package rosy.actions;

import io.appium.java_client.android.nativekey.AndroidKey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import rosy.platform.AppiumObject;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Swipe extends AppiumObject implements Interaction{

    public enum Direction {
        DOWN, UP, LEFT, RIGHT;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    Direction direction;
    Target Element;
    public Swipe(Target element, Direction direction)
    {
        this.Element = element;
        this.direction = direction;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (this.direction)
        {
            case UP: this.swipeUp(this.Element, actor);
            case DOWN: this.swipeDown(actor);
            case LEFT:this.swipeLeft(actor);
            case RIGHT:this.swipeRight(actor);
        }
    }

    public static SwipeBuilder on(Target element)
    {
        return new SwipeBuilder(element);
    }

    public static class SwipeBuilder
    {
        private Target Element;
        public SwipeBuilder(Target element)
        {
            this.Element = element;
        }

        public Interaction Up()
        {
            return instrumented(Swipe.class, this.Element, Direction.UP);
        }

        public Interaction Down()
        {
            return instrumented(Swipe.class, this.Element, Direction.DOWN);
        }

        public Interaction Left()
        {
            return instrumented(Swipe.class, this.Element, Direction.LEFT);
        }

        public Interaction Right()
        {
            return instrumented(Swipe.class, this.Element, Direction.RIGHT);
        }
    }
}