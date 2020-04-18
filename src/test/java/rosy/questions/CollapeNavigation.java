package rosy.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TheSize;
import rosy.ui.HomeScreen;

public class CollapeNavigation implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return TheSize.of(HomeScreen.LARGE_NAVIGATION).viewedBy(actor).resolve().width == 79;
    }
}
