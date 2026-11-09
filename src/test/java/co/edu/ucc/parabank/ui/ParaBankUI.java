package co.edu.ucc.parabank.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/** Los localizadores se deben confirmar con F12 > Inspeccionar antes de ejecutar. */
public final class ParaBankUI {
    private ParaBankUI() { }

    public static final Target USUARIO = Target.the("usuario de Customer Login")
        .located(By.cssSelector("#loginPanel input[name='username']"));
    public static final Target CLAVE = Target.the("contraseña de Customer Login")
        .located(By.cssSelector("#loginPanel input[name='password']"));
    public static final Target INGRESAR = Target.the("botón Log In")
        .located(By.cssSelector("#loginPanel input[value='Log In']"));
    public static final Target ENLACE_REGISTRO = Target.the("enlace Register")
        .located(By.linkText("Register"));
    public static final Target ERROR = Target.the("mensaje de error de acceso")
        .located(By.cssSelector("#rightPanel .error"));
    public static final Target TITULO_CUENTAS = Target.the("título Accounts Overview")
        .located(By.xpath("//h1[contains(normalize-space(.),'Accounts Overview')]"));
    public static final Target TITULO_ADMIN = Target.the("título Administration")
        .located(By.xpath("//h1[normalize-space(.)='Administration']"));
    public static final Target IR_TRANSFERIR = Target.the("opción Transfer Funds")
        .located(By.linkText("Transfer Funds"));
    public static final Target IMPORTE = Target.the("importe de transferencia")
        .located(By.id("amount"));
    public static final Target ORIGEN = Target.the("cuenta origen")
        .located(By.id("fromAccountId"));
    public static final Target DESTINO = Target.the("cuenta destino")
        .located(By.id("toAccountId"));
    public static final Target BOTON_TRANSFERIR = Target.the("botón Transfer")
        .located(By.cssSelector("input[value='Transfer']"));
    public static final Target TITULO_TRANSFERENCIA = Target.the("confirmación de transferencia")
        .located(By.xpath("//h1[contains(normalize-space(.),'Transfer Complete')]"));
    public static final Target IR_CUENTAS = Target.the("opción Accounts Overview")
        .located(By.linkText("Accounts Overview"));
    public static final Target REG_NOMBRE = Target.the("nombre de registro")
        .located(By.id("customer.firstName"));
    public static final Target REG_APELLIDO = Target.the("apellido de registro")
        .located(By.id("customer.lastName"));
    public static final Target REG_DIRECCION = Target.the("dirección de registro")
        .located(By.id("customer.address.street"));
    public static final Target REG_CIUDAD = Target.the("ciudad de registro")
        .located(By.id("customer.address.city"));
    public static final Target REG_ESTADO = Target.the("estado de registro")
        .located(By.id("customer.address.state"));
    public static final Target REG_ZIP = Target.the("código postal de registro")
        .located(By.id("customer.address.zipCode"));
    public static final Target REG_PHONE = Target.the("teléfono ficticio")
        .located(By.id("customer.phoneNumber"));
    public static final Target REG_SSN = Target.the("identificación ficticia")
        .located(By.id("customer.ssn"));
    public static final Target REG_USERNAME = Target.the("usuario de registro")
        .located(By.id("customer.username"));
    public static final Target REG_PASS = Target.the("contraseña de registro")
        .located(By.id("customer.password"));
    public static final Target REG_CONFIRM = Target.the("confirmación de contraseña")
        .located(By.id("repeatedPassword"));
    public static final Target REG_BUTTON = Target.the("botón Register")
        .located(By.cssSelector("input[value='Register']"));
    public static final Target REG_CONFIRMACION = Target.the("confirmación de registro")
        .located(By.cssSelector("#rightPanel h1"));
    public static final Target SALIR = Target.the("opción Log Out")
        .located(By.linkText("Log Out"));
}
