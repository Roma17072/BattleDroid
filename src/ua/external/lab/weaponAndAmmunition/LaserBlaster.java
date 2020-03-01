package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class LaserBlaster implements WeaponAble {
    @Override
    public String name() {
        return ViewConstant.LASER_BLASTER;
    }

    @Override
    public int impact() {
        return 17;
    }
}
