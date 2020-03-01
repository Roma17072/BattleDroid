package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class Blaster implements WeaponAble {

    @Override
    public String name() {
        return ViewConstant.BLASTER;
    }

    @Override
    public int impact() {
        return 15;
    }
}
