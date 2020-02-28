package ua.external.lab.repairable;

import ua.external.lab.repairable.RepairAble;

public class SuperRepair implements RepairAble {
    @Override
    public int repair() {
        return 7;
    }
}
