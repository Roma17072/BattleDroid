package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class RocketBlaster implements WeaponAble {
    @Override
    public String name() {
        return ViewConstant.ROCKET_BLASTER;
    }

    @Override
    public int impact() {
        return 19;
    }
}
