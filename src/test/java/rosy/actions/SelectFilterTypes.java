package rosy.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFilterTypes implements Interaction {
    private String[] types;
    public SelectFilterTypes(String types)
    {
        this.types = types.split(",");
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        for(String type:this.types)
        {
            WebElementFacade btnType = Target.the("Item \""+ type +"\"")
                    .locatedBy("//*[@text=\""+type+"\"]")
                    .resolveFor(actor);
            btnType.click();
        }
    }

    public static Interaction with(String types)
    {
        return instrumented(SelectFilterTypes.class, types);
    }
}
