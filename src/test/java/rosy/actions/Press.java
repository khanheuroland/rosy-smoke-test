package rosy.actions;

import net.serenitybdd.screenplay.Interaction;
import rosy.platform.AppiumObject;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import rosy.platform.AppiumObject;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Press extends AppiumObject implements Interaction {

    private static final Map<Integer, AndroidKey> KEYS_MAP = Arrays.stream(AndroidKey.values())
            .collect(Collectors.toMap(AndroidKey::getCode, key->key));

    private final AndroidKey key;

    public Press(AndroidKey key)
    {
        this.key = key;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver(actor).pressKey(new KeyEvent(key));
    }

    public static Interaction key(AndroidKey key)
    {
        return instrumented(Press.class, key);
    }

    public static Interaction key(int keyCode)
    {
        return key(KEYS_MAP.get(keyCode));
    }
}