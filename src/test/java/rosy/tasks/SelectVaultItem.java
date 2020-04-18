package rosy.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import rosy.actions.SelectFilterTypes;
import rosy.ui.VaultScreen;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectVaultItem implements Task {
    int index=0;
    public SelectVaultItem(int _index)
    {
        this.index=_index;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> lstVaults = VaultScreen.VAULT_ITEMS.resolveAllFor(actor);
        actor.attemptsTo(
                Click.on(lstVaults.get(this.index))
        );
    }

    public static SelectVaultItem at(int index)
    {
        return instrumented(SelectVaultItem.class, index);
    }
}
