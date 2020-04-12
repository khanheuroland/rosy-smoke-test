package rosy.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import rosy.ui.HomeScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {
    String type="show";
    public Navigate(String type)
    {
        this.type = type;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(this.type=="show").andIfSo(
                        Click.on(HomeScreen.SHOW_NAVIGATION)
                ).otherwise(
                        Click.on(HomeScreen.HIDE_NAVIGATION)
                )
        );
    }

    public static Navigate show()
    {
        return instrumented(Navigate.class, "show");
    }

    public static Navigate hide()
    {
        return instrumented(Navigate.class, "hide");
    }
}
