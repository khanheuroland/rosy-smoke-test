package rosy.tasks;

import io.appium.java_client.android.nativekey.AndroidKey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import rosy.actions.Press;
import rosy.ui.VaultScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchVault implements Task {
    private String Keyword;
    public SearchVault(String keyword)
    {
        this.Keyword = keyword;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(VaultScreen.SEARCH_BUTTON),
                Click.on(VaultScreen.INPUT_SEARCH_BOX),
                Enter.theValue(this.Keyword).into(VaultScreen.SEARCH_INPUT),
                Press.key(AndroidKey.ENTER)
        );
    }

    public static SearchVault withKeyword(String keyword)
    {
        return instrumented(SearchVault.class, keyword);
    }
}
