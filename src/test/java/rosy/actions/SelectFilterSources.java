package rosy.actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFilterSources implements Interaction {
    String[] sources;
    public SelectFilterSources(String sources)
    {
        this.sources = sources.split(",");
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        for(String source:this.sources)
        {
            WebElementFacade btnSource = Target.the("Source \""+ source +"\"")
                    .locatedBy("//*[@text=\""+source+"\"]")
                    .resolveFor(actor);
            btnSource.click();
        }
    }

    public static Interaction with(String sources)
    {
        return instrumented(SelectFilterSources.class, sources);
    }
}
