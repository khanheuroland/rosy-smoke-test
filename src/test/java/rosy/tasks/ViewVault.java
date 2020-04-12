package rosy.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import rosy.actions.ChoosePicture;
import rosy.ui.AddVaultScreen;
import rosy.ui.VaultScreen;
import rosy.ui.ViewVaultScreen;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewVault implements Task {
    int index=0;
    public ViewVault(int index)
    {
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> lstVaults = VaultScreen.VAULT_ITEMS.resolveAllFor(actor);
        if(index<0)
        {
            Random rdn = new Random();
            index = rdn.nextInt(lstVaults.size());
        }
        actor.attemptsTo(
                Click.on(lstVaults.get(this.index)),
                Click.on(ViewVaultScreen.BACK_TO_VAULT)
        );
    }

    public static ViewVault at(int index)
    {
        return instrumented(ViewVault.class, index);
    }

    public static ViewVault random()
    {
        return instrumented(ViewVault.class, -1);
    }
}
