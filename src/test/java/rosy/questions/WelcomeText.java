package rosy.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rosy.ui.HomeScreen;
import rosy.ui.WelcomeScreen;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WelcomeText implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(WelcomeScreen.WELCOME_TEXT).viewedBy(actor).asString();
    }
}
