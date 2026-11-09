package co.edu.ucc.parabank.tasks;

import co.edu.ucc.parabank.ui.ParaBankUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

/** Altera saldos de la cuenta de demostración: requiere habilitación explícita. */
public final class TransferirDinero {
    private TransferirDinero() { }
    public static Performable entre(String origen, String destino, String cantidad) {
        return Task.where("{0} transfiere un monto entre dos cuentas de prueba",
            Click.on(ParaBankUI.IR_TRANSFERIR),
            Enter.theValue(cantidad).into(ParaBankUI.IMPORTE),
            SelectFromOptions.byVisibleText(origen).from(ParaBankUI.ORIGEN),
            SelectFromOptions.byVisibleText(destino).from(ParaBankUI.DESTINO),
            Click.on(ParaBankUI.BOTON_TRANSFERIR));
    }
}
