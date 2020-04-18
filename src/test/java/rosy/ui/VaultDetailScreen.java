package rosy.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VaultDetailScreen {
    public static Target CONTAINER = Target.the("The vault detail screen")
            .located(By.xpath("//*[@content-desc=\"addStoryButton\"]"));

    public static Target BACK_TO_VAULT = Target.the("Back to vault screen")
            .located(By.xpath("//*[@content-desc=\"details_button\"]/following-sibling::android.view.ViewGroup"));
}
