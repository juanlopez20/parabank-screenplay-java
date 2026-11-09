package co.edu.ucc.parabank.questions;

import co.edu.ucc.parabank.ui.ParaBankUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

/** Las Questions centralizan lo que se pregunta al sistema. */
public final class EstadoDeParaBank {
    private EstadoDeParaBank() { }
    public static Question<String> mensajeDeError() {
        return actor -> Text.of(ParaBankUI.ERROR).answeredBy(actor);
    }
}
