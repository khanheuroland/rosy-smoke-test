package rosy.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import rosy.questions.TheResults;
import rosy.tasks.Login;
import rosy.tasks.OpenLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class LoginStory {
    Actor anna = Actor.named("The User");

    @Managed(uniqueSession = true, driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void show_home_screen_after_logged_in_with_rosy_account() {
        anna.attemptsTo(
                OpenLogin.open(),
                Login.withEmail("linh.le@wrethink.com").andPassword("12345")
        );

        anna.should(
                seeThat(TheResults.welcomeText(), equalTo("Hi, Le!"))
        );
    }
}
