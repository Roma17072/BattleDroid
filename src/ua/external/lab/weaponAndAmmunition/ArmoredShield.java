package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class ArmoredShield implements AmmunitionAble{
    @Override
    public String name() {
        return ViewConstant.ARMORED_SHIELD;
    }

    @Override
    public int protect() {
        return 31;
    }
}
