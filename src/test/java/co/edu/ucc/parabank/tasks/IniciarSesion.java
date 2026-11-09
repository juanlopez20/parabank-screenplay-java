package co.edu.ucc.parabank.tasks;

import co.edu.ucc.parabank.ui.ParaBankUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public final class IniciarSesion {
    private IniciarSesion() { }
    public static Performable con(String usuario, String clave) {
        return Task.where("{0} intenta iniciar sesión en ParaBank",
            Enter.theValue(usuario).into(ParaBankUI.USUARIO),
            Enter.theValue(clave).into(ParaBankUI.CLAVE),
            Click.on(ParaBankUI.INGRESAR));
    }
}
