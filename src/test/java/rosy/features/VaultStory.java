package rosy.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import rosy.models.DataStore;
import rosy.questions.TheResults;
import rosy.tasks.FilterVault;
import rosy.tasks.OpenVault;
import rosy.tasks.SearchVault;
import rosy.tasks.SelectVaultItem;
import rosy.ui.VaultScreen;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class VaultStory {
    Actor anna = Actor.named("The User");

    @Managed(driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void show_the_result_after_search_with_keyword()
    {
        anna.attemptsTo(
                OpenVault.open(),
                SearchVault.withKeyword("Flower")
        );
        anna.should(
                seeThat(TheResults.searchedVaultSummary(), equalTo("5 total items"))
        );
    }


    @Test
    public void show_the_vault_detail_after_choose_a_vault_item()
    {
        anna.attemptsTo(
                OpenVault.open(),
                SearchVault.withKeyword("Flower"),
                SelectVaultItem.at(0)
        );

        anna.should(
                seeThat(TheResults.vaultDetailIsDisplay(), equalTo(true))
        );
    }


    @Test
    public void reset_the_list_of_vault_after_tap_on_the_clear_search()
    {
        anna.attemptsTo(
                OpenVault.open(),
                SearchVault.withKeyword("Flower")
        );
        anna.should(
                seeThat(TheResults.searchedVaultSummary(), equalTo("5 total items"))
        );

        anna.attemptsTo(
                Click.on(VaultScreen.CLEAR_SEARCH_BUTTON)
        );
        anna.should(
                seeThat(TheResults.searchedVaultSummary(), equalTo("385 total items"))
        );
    }

    @Test
    public void show_the_list_of_vault_corresponding_types_and_source()
    {
        anna.attemptsTo(
                OpenVault.open(),
                FilterVault.withTypes(DataStore.VaultFilterTypes).andSources(DataStore.VaultFilterSources).apply()
        );
        anna.should(
                seeThat(TheResults.searchedVaultSummary(), equalTo("380 total items"))
        );
    }
}
