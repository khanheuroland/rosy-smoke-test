package rosy.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import rosy.tasks.AddVault;

@RunWith(SerenityRunner.class)
public class AddVaultStory {
    Actor anna = Actor.named("The User");

    @Managed(driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void show_the_new_vault_item_on_the_list_after_add_a_new_one()
    {
        anna.attemptsTo(
                AddVault.add()
        );
    }
}
