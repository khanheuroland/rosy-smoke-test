package rosy.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import rosy.ui.HomeScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LocationPermission implements Task {
    boolean isAllow = false;
    public LocationPermission(boolean isAllow)
    {
        this.isAllow=isAllow;
    }
    @Override
    @Step("{0} allow the Location permission access")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(isAllow).andIfSo(
                        Click.on(HomeScreen.ALLOW)
                ).otherwise(
                        Click.on(HomeScreen.DENY)
                ),
                WaitUntil.the(HomeScreen.DETECTED_LOCATION, isVisible()).forNoMoreThan(60).seconds()
        );
    }

    public static LocationPermission Deny()
    {
        return instrumented(LocationPermission.class, false);
    }

    public static LocationPermission Allow()
    {
        return instrumented(LocationPermission.class, true);
    }
}
