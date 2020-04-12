package rosy.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import rosy.ui.WelcomeScreen;

public class OpenLogin implements Task {
    @Step("Open login screen")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(WelcomeScreen.LOGIN_BUTTON, isVisible()).forNoMoreThan(60).seconds(),
                Click.on(WelcomeScreen.LOGIN_BUTTON)
        );
    }

    public static OpenLogin open() {
        return instrumented(OpenLogin.class);
    }

}
