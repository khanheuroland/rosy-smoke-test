package rosy.questions;

import net.serenitybdd.screenplay.Question;

public class TheResults {
    public static Question<String> welcomeText(){return new WelcomeText();}
    public static Question<Boolean> expandNavigation() { return new ExpandNaviation();}
    public static Question<Boolean> collapNavigation() {return new CollapeNavigation();}
    public static Question<String> detectedLocation(){return new DetectedLocation();}
    public static Question<Boolean> vaultScreenIsDisplay(){return new VaultScreenDisplay();}
    public static Question<Boolean> vaultDetailIsDisplay(){return new VaultDetailDisplay();}
    public static Question<String> searchedVaultSummary(){return new VaultSearchResult();}
}
