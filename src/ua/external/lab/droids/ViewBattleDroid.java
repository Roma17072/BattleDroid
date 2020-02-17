package ua.external.lab.droids;

import java.util.ResourceBundle;

public class ViewBattleDroid {
    public static final String BASE_PARAMETERS = "Base droids parameters:\n";
    public static final String ATTACK = " droid attack";
    public static final String FINAL_PARAMETERS = "Final Droids parameters with weapon and ammunition:\n";
    public static final String WELCOME = "Welcome to battle of Droids";
    public static final String WEAPONS_AND_AMMUNITION = " droid weapon and ammunition";
    public static final String ROUND = "Round number ";
    public static final String INJURIES = " injuries: ";
    public static final String WIN = " win";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printBaseParameters(Droid first, Droid second) {
        printMessage(BASE_PARAMETERS + first + "\n" + second + "\n");
    }

    public void printWeaponsAndAmmunition(Droid first, Droid second) {
        printMessage(first.getName() + WEAPONS_AND_AMMUNITION + "\n"
                + first.getListWeaponsAndAmmunition() + "\n"
                + second.getName() + WEAPONS_AND_AMMUNITION + "\n"
                + second.getListWeaponsAndAmmunition() + "\n");
    }

    public void printFinalParameters(Droid first, Droid second) {
        printMessage(FINAL_PARAMETERS + first + "\n" + second + "\n");
    }

    public void printAttackDroid(Droid droid) {
        printMessage(droid.getName() + ATTACK);
    }

    public void printRound(int i) {
        printMessage(ROUND + i + "\n");
    }

    public void printInjuries(Droid droid) {
        printMessage(droid.getName() + INJURIES + "\n" + droid);
    }
}