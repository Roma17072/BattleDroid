package ua.external.lab.droids;

import ua.external.lab.repairable.NotRepair;

public class Terminator extends Droid implements HeavyDroid {

    public Terminator(int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new NotRepair();
    }
    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public int range() {
        return 2;
    }
}
