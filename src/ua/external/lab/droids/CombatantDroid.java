package ua.external.lab.droids;

import ua.external.lab.repairable.SimpleRepair;

public class CombatantDroid extends Droid implements HeavyDroid {

    public CombatantDroid(int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new SimpleRepair();
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int range() {
        return 1;
    }
}
