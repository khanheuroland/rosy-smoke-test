package rosy.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import rosy.actions.ChoosePicture;
import rosy.ui.AddVaultScreen;
import rosy.ui.HomeScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddVault implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomeScreen.ADD_VAULT_BUTTON),
                Click.on(AddVaultScreen.ENABLE_ACCESS),
                Click.on(AddVaultScreen.ALLOW_ACCESS),
                ChoosePicture.random(),
                Click.on(AddVaultScreen.UPLOAD)
        );

    }

    public static AddVault add()
    {
        return instrumented(AddVault.class);
    }
}
