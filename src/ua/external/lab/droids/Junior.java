package ua.external.lab.droids;

import ua.external.lab.repairable.SuperRepair;

public class Junior extends Droid implements liteDroid {

    public Junior(int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new SuperRepair();
    }

    @Override
    public int range() {
        return 1;
    }

    @Override
    public String toString() {
        return  super.toString();
    }

}
