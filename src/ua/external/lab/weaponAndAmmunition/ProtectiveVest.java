package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class ProtectiveVest implements AmmunitionAble {
    @Override
    public String name() {
        return ViewConstant.VEST;
    }

    @Override
    public int protect() {
        return 26;
    }
}
