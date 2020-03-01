package ua.external.lab.droids;
import ua.external.lab.repairable.SimpleRepair;

public class SimpleDroid extends Droid implements liteDroid {

    public SimpleDroid (int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new SimpleRepair();
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
