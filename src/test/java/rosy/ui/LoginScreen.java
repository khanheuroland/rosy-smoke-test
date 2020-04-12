package rosy.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginScreen {
    public static Target EMAIL_FIELD = Target.the("Email field")
            .located(By.className("android.widget.EditText")); //Have to make the content-description

    public static Target PASSWORD_FIELD = Target.the("Password field")
            .located(By.xpath("(//android.view.ViewGroup)[4]"));

    public static Target CONTINUE_BUTTON = Target.the("Continue button")
            .located(By.xpath("//*[@text=\"Continue\"]"));
}
