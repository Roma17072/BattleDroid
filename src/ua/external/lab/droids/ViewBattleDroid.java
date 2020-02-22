package ua.external.lab.droids;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewBattleDroid extends ViewConstant {
    public ResourceBundle bundle;
    public static final String CHOSE_LANGUAGE ="Chose language please:\n1 English\n2 Ukrainian";
    public static final String WRONG = "Wrong input! Repeat please!";
    public static final String MESSAGES_BUNDLE_NAME = "property.text";
    //  view Language
    public void viewLanguage(int i){
        String country = "";
        String language = "";
        switch (i) {
            case 1:
                country = ("US");
                language = ("en");
                break;
            case 2:
                country = ("UA");
                language = ("uk");
                break;
        }
        Locale current = new Locale(language, country);
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, current);
    }

    public void printMessage(String message) {
        System.out.println(bundle.getString(message));
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public void printBaseParameters(Droid first, Droid second) {
        print(bundle.getString(BASE_PARAMETERS) + "Name " + first.getName() + first + "\n"
                    + "Name " + second.getName()+ second + "\n");
    }

    public void printWeaponsAndAmmunition(Droid first, Droid second) {
        print(first.getName() + bundle.getString(WEAPONS_AND_AMMUNITION) + "\n"
                + first.getListWeaponsAndAmmunition() + "\n"
                + second.getName() + bundle.getString(WEAPONS_AND_AMMUNITION) + "\n"
                + second.getListWeaponsAndAmmunition() + "\n");
    }

    public void printFinalParameters(Droid first, Droid second) {
        print(bundle.getString(FINAL_PARAMETERS) + first.getName() + first + "\n"
                     + second.getName()+ second + "\n");
    }

    public void printAttackDroid(Droid droid) {
        print(droid.getName() + bundle.getString(ATTACK));
    }

    public void printRound(int i) {
        print("\n" +bundle.getString(ROUND) + i );
    }

    public void printInjuries(Droid droid) {
        print(droid.getName() + bundle.getString(INJURIES) + droid);
    }

    public void printRepair(Droid droid, int i) {
        print(droid.getName()+ bundle.getString(REPAIR) + i);
    }

    public void printParameters (Droid droid) {
        print(droid.getName() + droid);
    }

    public void printWinner(String droid){
        print(droid + bundle.getString(WIN));
    }

    public void printBattle(Droid first, Droid second) {
        print(bundle.getString(TODAY_BATTLE) + first.getName() +
                bundle.getString(AND) + second.getName()+"\n");
    }

    public void printChooseDroids(String droid) {
        print(droid + bundle.getString(CHOOSE_DROID));
    }

}
