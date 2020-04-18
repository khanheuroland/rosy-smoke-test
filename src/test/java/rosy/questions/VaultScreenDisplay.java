package rosy.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import rosy.ui.VaultScreen;

public class VaultScreenDisplay implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(VaultScreen.VAULT_SCREEN_TITLE).viewedBy(actor).resolve();
    }
}
