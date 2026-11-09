package co.edu.ucc.parabank.stepdefinitions;

import co.edu.ucc.parabank.questions.EstadoDeParaBank;
import co.edu.ucc.parabank.tasks.AbrirPagina;
import co.edu.ucc.parabank.tasks.IniciarSesion;
import co.edu.ucc.parabank.tasks.RegistrarCliente;
import co.edu.ucc.parabank.tasks.TransferirDinero;
import co.edu.ucc.parabank.ui.ParaBankUI;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.actions.Click;
import org.junit.jupiter.api.Assertions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class ParaBankSteps {
    private Actor usuario() { return OnStage.theActorCalled("Cliente de prueba"); }

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el visitante abre la página principal de ParaBank")
    public void visitarInicio() {
        usuario().wasAbleTo(AbrirPagina.inicio());
    }

    @Entonces("debe visualizar el formulario de acceso")
    public void existeLogin() {
        usuario().attemptsTo(Ensure.that(ParaBankUI.USUARIO).isDisplayed());
        usuario().attemptsTo(Ensure.that(ParaBankUI.CLAVE).isDisplayed());
        usuario().attemptsTo(Ensure.that(ParaBankUI.ENLACE_REGISTRO).isDisplayed());
    }

    @Cuando("intenta ingresar con el usuario {string} y la clave {string}")
    public void ingresarInvalido(String nombre, String clave) {
        usuario().attemptsTo(IniciarSesion.con(nombre, clave));
    }


    @Entonces("el sitio debe mostrar un mensaje de error de acceso")
    public void accesoRechazado() {
        usuario().attemptsTo(
                WaitUntil.the(
                        ParaBankUI.ERROR,
                        containsText("The username and password could not be verified")
                ).forNoMoreThan(15).seconds()
        );

        String mensaje = usuario().asksFor(
                EstadoDeParaBank.mensajeDeError()
        );

        Assertions.assertTrue(
                mensaje.contains("The username and password could not be verified"),
                "No se encontró el mensaje esperado. Mensaje obtenido: " + mensaje
        );
    }


    @Dado("que el visitante abre Administration sin credenciales")
    public void irAAdministracion() {
        usuario().wasAbleTo(AbrirPagina.administracion());
    }

    @Entonces("la interfaz administrativa debería permanecer restringida")
    public void paginaAdministrativaRestringida() {
        // Una ejecución fallida documentaría el hallazgo H-01. No ejecuta botones.
        usuario().attemptsTo(Ensure.that(ParaBankUI.TITULO_ADMIN).isNotDisplayed());
    }

    @Cuando("ingresa con las credenciales de prueba configuradas")
    public void ingresarValido() {
        String login = System.getenv("PARABANK_USER");
        if (login == null || login.isBlank()) login = System.getProperty("parabank.user", "");
        String clave = System.getenv("PARABANK_PASSWORD");
        if (clave == null || clave.isBlank()) clave = System.getProperty("parabank.password", "");
        Assertions.assertFalse(login.isBlank() || clave.isBlank(),
            "Configura PARABANK_USER y PARABANK_PASSWORD como variables de entorno de una cuenta ficticia");
        usuario().attemptsTo(IniciarSesion.con(login, clave));
    }

    @Entonces("debe visualizar el resumen de cuentas")
    public void resumenVisible() {
        usuario().attemptsTo(Ensure.that(ParaBankUI.TITULO_CUENTAS).isDisplayed());
    }

    @Cuando("abre Accounts Overview desde el menú")
    public void abrirCuentas() {
        usuario().attemptsTo(Click.on(ParaBankUI.IR_CUENTAS));
    }

    @Cuando("cierra la sesión")
    public void cerrarSesion() {
        usuario().attemptsTo(Click.on(ParaBankUI.SALIR));
    }

    @Cuando("registra un nuevo cliente ficticio")
    public void registrarClienteFicticio() {
        Assertions.assertTrue(Boolean.getBoolean("parabank.permitir.escritura"),
            "Registro deshabilitado sin permiso explícito -Dparabank.permitir.escritura=true");
        String alias = "qa_ucc_" + System.currentTimeMillis();
        usuario().attemptsTo(RegistrarCliente.ficticio(alias));
    }

    @Entonces("debe ver la confirmación de registro")
    public void confirmarRegistro() {
        usuario().attemptsTo(Ensure.that(ParaBankUI.REG_CONFIRMACION).text().contains("Welcome"));
    }

    @Cuando("transfiere {string} de la cuenta {string} a la cuenta {string}")
    public void transferir(String monto, String origen, String destino) {
        Assertions.assertTrue(Boolean.getBoolean("parabank.permitir.escritura"),
            "Prueba de escritura bloqueada. Habilita -Dparabank.permitir.escritura=true si autorizas modificar cuentas de PRUEBA");
        Assertions.assertNotEquals(origen, destino, "El origen y el destino deben ser distintos");
        usuario().attemptsTo(TransferirDinero.entre(origen, destino, monto));
    }

    @Entonces("debe mostrar la confirmación de transferencia")
    public void confirmarTransferencia() {
        usuario().attemptsTo(Ensure.that(ParaBankUI.TITULO_TRANSFERENCIA).isDisplayed());
    }
}
