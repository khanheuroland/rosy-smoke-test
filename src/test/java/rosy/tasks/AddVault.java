package rosy.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rosy.actions.ChoosePicture;
import rosy.ui.AddVaultScreen;
import rosy.ui.HomeScreen;
import rosy.ui.VaultScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddVault implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeScreen.ADD_VAULT_BUTTON),
                Click.on(AddVaultScreen.ENABLE_ACCESS),
                Click.on(AddVaultScreen.ALLOW_ACCESS),
                ChoosePicture.random(),
                Click.on(AddVaultScreen.UPLOAD),
                WaitUntil.the(VaultScreen.VAULT_SCREEN_TITLE, isVisible()).forNoMoreThan(15).seconds()
        );

    }

    public static AddVault add()
    {
        return instrumented(AddVault.class);
    }
}
