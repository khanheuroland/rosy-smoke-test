package rosy.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import rosy.models.DataStore;
import rosy.questions.TheResults;
import rosy.tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

@RunWith(SerenityRunner.class)
public class SmokeTestingStory {

    Actor anna = Actor.named("Rosy User");

    @Managed(uniqueSession = true, driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void Rosy_smoke_test_case() {
        anna.attemptsTo(
                OpenLogin.open(),
                Login.withEmail("linh.le@wrethink.com").andPassword("12345")
        );
        anna.should(
                seeThat(
                        TheResults.homeScreenIsDisplayed(), equalTo(true))
        );

        //Allow Location permission
        anna.attemptsTo(
                LocationPermission.Allow()
        );
        anna.should(
                seeThat(
                        TheResults.detectedLocation(), startsWith("Hà Nội")
                )
        );


        //Show/Hide navigation
        anna.attemptsTo(
                Navigate.show(),
                Navigate.hide()
        );


        //Vault
        //Search
        anna.attemptsTo(
                OpenVault.open(),
                SearchVault.withKeyword("Flower")
        );
        anna.should(
                seeThat(TheResults.searchedVaultSummary(), equalTo("3 total items"))
        );

        //Filter
        anna.attemptsTo(
                FilterVault.withTypes(DataStore.VaultFilterTypes).andSources(DataStore.VaultFilterSources).apply()
        );
        anna.should(
                seeThat(TheResults.searchedVaultSummary(), equalTo("359 total items"))
        );

        //Add Vault
        anna.attemptsTo(
                AddVault.add()
        );

        //View Vault
        anna.attemptsTo(
                ViewVault.random()
        );


        anna.attemptsTo(
                Logout.click()
        );
    }

}