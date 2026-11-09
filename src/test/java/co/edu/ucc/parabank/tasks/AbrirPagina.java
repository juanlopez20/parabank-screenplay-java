package co.edu.ucc.parabank.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public final class AbrirPagina {
    private static final String BASE = "https://parabank.parasoft.com/parabank/";
    private AbrirPagina() { }
    public static Performable inicio() {
        return Task.where("{0} abre el inicio de ParaBank", Open.url(BASE + "index.htm"));
    }
    public static Performable administracion() {
        return Task.where("{0} abre Administration sin autenticarse", Open.url(BASE + "admin.htm"));
    }
}
