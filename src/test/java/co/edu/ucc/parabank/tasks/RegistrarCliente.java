package co.edu.ucc.parabank.tasks;

import co.edu.ucc.parabank.ui.ParaBankUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

/** Datos 100% ficticios. No utilizar credenciales reales. */
public final class RegistrarCliente {
    private RegistrarCliente() { }
    public static Performable ficticio(String usuario) {
        return Task.where("{0} registra un cliente ficticio para pruebas",
            Click.on(ParaBankUI.ENLACE_REGISTRO),
            Enter.theValue("Prueba").into(ParaBankUI.REG_NOMBRE),
            Enter.theValue("Calidad").into(ParaBankUI.REG_APELLIDO),
            Enter.theValue("Calle Inventada 123").into(ParaBankUI.REG_DIRECCION),
            Enter.theValue("Ciudad Prueba").into(ParaBankUI.REG_CIUDAD),
            Enter.theValue("Departamento Test").into(ParaBankUI.REG_ESTADO),
            Enter.theValue("00000").into(ParaBankUI.REG_ZIP),
            Enter.theValue("0000000000").into(ParaBankUI.REG_PHONE),
            Enter.theValue("000000000").into(ParaBankUI.REG_SSN),
            Enter.theValue(usuario).into(ParaBankUI.REG_USERNAME),
            Enter.theValue("ClaveFicticiaSoloPruebas!2026").into(ParaBankUI.REG_PASS),
            Enter.theValue("ClaveFicticiaSoloPruebas!2026").into(ParaBankUI.REG_CONFIRM),
            Click.on(ParaBankUI.REG_BUTTON));
    }
}
