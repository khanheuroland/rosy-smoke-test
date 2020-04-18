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
import rosy.tasks.LocationPermission;
import rosy.tasks.Navigate;
import rosy.tasks.OpenVault;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

@RunWith(SerenityRunner.class)
public class HomeStory {
    Actor anna = Actor.named("The User");

    @Managed(driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void allow_the_location_access_permission()
    {
        anna.attemptsTo(
                LocationPermission.Allow()
        );
        anna.should(
                seeThat(
                        TheResults.detectedLocation(), startsWith("Hà Nội")
                )
        );
    }

    @Test
    public void show_and_hide_the_navigation_bar()
    {
        anna.attemptsTo(Navigate.show());
        anna.should(seeThat(TheResults.expandNavigation(), equalTo(true)));

        anna.attemptsTo(Navigate.hide());
        anna.should(seeThat(TheResults.collapNavigation(), equalTo(true)));
    }

    @Test
    public void show_the_corresponding_screen_after_tap_on_each_navigation_item()
    {
        anna.attemptsTo(OpenVault.open());
        anna.should((seeThat(TheResults.vaultScreenIsDisplay(), equalTo(true))));
    }
}
