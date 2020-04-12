package rosy.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rosy.ui.HomeScreen;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomeScreenDisplayed implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(HomeScreen.LOCATION_PERMISSION).viewedBy(actor).resolve();
    }
}
