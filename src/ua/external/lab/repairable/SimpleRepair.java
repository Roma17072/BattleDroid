package ua.external.lab.repairable;

import ua.external.lab.repairable.RepairAble;

public class SimpleRepair implements RepairAble {
    @Override
    public int repair() {
        return 5;
    }
}
