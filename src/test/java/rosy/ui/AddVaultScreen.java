package rosy.ui;


import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddVaultScreen {
    public static Target ENABLE_ACCESS = Target.the("Enable access to picture button")
            .located(By.xpath("//*[@text=\"Enable Access\"]"));

    public static Target ALLOW_ACCESS = Target.the("Allow button")
            .located(By.id("com.android.packageinstaller:id/permission_allow_button"));

    public static Target PICTURE_LIST = Target.the("Picture list")
            .located(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"));

    public static Target UPLOAD = Target.the("Upload button")
            .located(By.xpath("//*[starts-with(@text, \"Upload\")]"));
}
