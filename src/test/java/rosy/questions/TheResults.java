package rosy.questions;

import net.serenitybdd.screenplay.Question;
import rosy.tasks.SearchVault;

public class TheResults {
    public static Question<Boolean> homeScreenIsDisplayed(){return new HomeScreenDisplayed();}
    public static Question<String> detectedLocation(){return new DetectedLocation();}
    public static Question<String> searchedVaultSummary(){return new VaultSearchResult();}
}
