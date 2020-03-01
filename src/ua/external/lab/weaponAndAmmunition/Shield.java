package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class Shield implements AmmunitionAble {
    @Override
    public String name() {
        return ViewConstant.SHIELD;
    }

    @Override
    public int protect() {
        return 23;
    }
}
