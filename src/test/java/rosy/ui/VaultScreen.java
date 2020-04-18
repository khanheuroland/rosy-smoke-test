package rosy.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VaultScreen {
    public static Target VAULT_SCREEN_TITLE = Target.the("Vault screen")
            .located(By.xpath("//*[@text=\"My vault | \"]"));

    public static Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.xpath("//*[@content-desc=\"SearchPillAnimatedSearchButton\"]"));

    public static Target INPUT_SEARCH_BOX = Target.the("Input keyword box")
            .located(By.xpath("//*[@content-desc=\"SearchPanelRenderPrimaryInputTouchable\"]"));

    public static Target SEARCH_INPUT = Target.the("Search Vault input")
            .located(By.xpath("//*[@content-desc=\"SearchPanelSearchInput\"]"));

    public static Target SEARCH_RESULT_SUMMARY = Target.the("Search result summary")
            .located(By.xpath("//*[@content-desc=\"SearchPillAnimatedSearchButton\"]/../android.widget.TextView"));

    public static Target CLEAR_SEARCH_BUTTON = Target.the("Clear search button")
            .located(By.xpath("//*[@text=\"Clear search\"]/.."));

    public static Target FILTER_BUTTON = Target.the("Filter button")
            .located(By.xpath("//*[@content-desc=\"FiltersPillAnimatedFilterButton\"]"));

    public static Target APPLY_FILTER_BUTTON = Target.the("Apply filter button")
            .located(By.xpath("//*[@content-desc=\"FiltersPanelViewToggleFilterButton\"]"));

    public static Target VAULT_ITEMS = Target.the("Vault items")
            .located(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"));

}
