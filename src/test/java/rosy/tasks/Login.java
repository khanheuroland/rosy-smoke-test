package rosy.tasks;

import io.appium.java_client.android.nativekey.AndroidKey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import rosy.actions.Press;
import rosy.ui.HomeScreen;
import rosy.ui.LoginScreen;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {
    String email;
    String password;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.email).into(LoginScreen.EMAIL_FIELD),
                Press.key(AndroidKey.ENTER),
                Press.key(Integer.parseInt(String.valueOf(1))+7),
                Press.key(Integer.parseInt(String.valueOf(2))+7),
                Press.key(Integer.parseInt(String.valueOf(3))+7),
                Press.key(Integer.parseInt(String.valueOf(4))+7),
                Press.key(Integer.parseInt(String.valueOf(5))+7),
                Press.key(AndroidKey.ENTER),
                Click.on(LoginScreen.CONTINUE_BUTTON),
                WaitUntil.the(HomeScreen.LOCATION_PERMISSION, isVisible()).forNoMoreThan(60).seconds()
        );
    }

    public Login(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public static LoginBuilder withEmail(String email)
    {
        return new LoginBuilder(email);
    }

    public static class LoginBuilder
    {
        private String email;
        public LoginBuilder(String email)
        {
            this.email = email;
        }

        public Login andPassword(String password)
        {
            return instrumented(Login.class, email, password);
        }
    }
}
