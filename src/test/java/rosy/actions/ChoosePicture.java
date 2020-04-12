package rosy.actions;

import io.appium.java_client.android.nativekey.AndroidKey;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import rosy.ui.AddVaultScreen;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChoosePicture implements Interaction {
    int index=0;
    public ChoosePicture(int index)
    {
        this.index = index;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> lstPictures = AddVaultScreen.PICTURE_LIST.resolveAllFor(actor);
        if(index<0)
        {
            Random rdn = new Random();
            index = rdn.nextInt(lstPictures.size());
        }
        actor.attemptsTo(
                Click.on(lstPictures.get(this.index))
        );
    }

    public static Interaction at(int index)
    {
        return instrumented(ChoosePicture.class, index);
    }

    public static Interaction random()
    {
        return instrumented(ChoosePicture.class, -1);
    }
}
