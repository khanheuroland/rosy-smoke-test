package rosy.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeScreen {
    public static final Target SHOW_NAVIGATION = Target.the("Show navigation button")
            .located(By.xpath("(//*[@content-desc=\"rosy_icon\"])[2]/following-sibling::android.view.ViewGroup"));
    public static final Target HIDE_NAVIGATION = Target.the("Show navigation button")
            .located(By.xpath("(//android.view.ViewGroup[@content-desc=\"rosy_icon\"]/following-sibling::android.view.ViewGroup)[3]"));

    public static final Target LARGE_NAVIGATION = Target.the("The Navigation bar")
            .located(By.xpath("//*[@content-desc=\"home_icon\"]/.."));

    public static final Target LOGOUT_BUTTON = Target.the("Logout button")
            .located(By.xpath("//*[@text=\"Log out\"]/.."));
    public static final Target ITEM_LIST = Target.the("Item list")
            .located(By.xpath("//android.widget.HorizontalScrollView"));

    public static Target LOCATION_PERMISSION = Target.the("Location request permission")
            .located(By.id("com.android.packageinstaller:id/dialog_container"));
    public static Target DENY = Target.the("Deny button")
            .located(By.id("com.android.packageinstaller:id/permission_deny_button"));
    public static Target ALLOW = Target.the("Allow button")
            .located(By.id("com.android.packageinstaller:id/permission_allow_button"));

    public static Target DETECTED_LOCATION = Target.the("Detected Location")
            .located(By.xpath("//*[@content-desc=\"weatherDescription_label\"]/android.widget.TextView[2]"));

    public static Target VAULT_NAVIGATION_BUTTON = Target.the("Vault button on navigation")
            .located(By.xpath("//*[@content-desc=\"vault_icon\"]"));
    public static Target ADD_VAULT_BUTTON = Target.the("Add Vault button")
            .located(By.xpath("//*[@content-desc=\"add_vault\"]"));

}
