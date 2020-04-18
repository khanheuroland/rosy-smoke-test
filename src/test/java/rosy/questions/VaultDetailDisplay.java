package rosy.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import rosy.ui.VaultDetailScreen;
import rosy.ui.VaultScreen;

public class VaultDetailDisplay implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(VaultDetailScreen.CONTAINER).viewedBy(actor).resolve();
    }
}
