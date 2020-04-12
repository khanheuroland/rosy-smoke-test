package rosy.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import rosy.ui.HomeScreen;

public class DetectedLocation implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HomeScreen.DETECTED_LOCATION).viewedBy(actor).asString();
    }
}
