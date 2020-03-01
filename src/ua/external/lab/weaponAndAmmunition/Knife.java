package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class Knife implements WeaponAble {
    @Override
    public String name() {
        return ViewConstant.KNIFE;
    }

    @Override
    public int impact() {
        return 12;
    }
}
