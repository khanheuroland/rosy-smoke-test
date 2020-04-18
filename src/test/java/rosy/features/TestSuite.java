package rosy.features;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginStory.class,
        HomeStory.class,
        VaultStory.class,
        AddVaultStory.class,
        LogoutStory.class
})
public class TestSuite {

}
