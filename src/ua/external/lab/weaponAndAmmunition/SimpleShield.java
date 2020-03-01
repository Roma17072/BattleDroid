package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.mvc.ViewConstant;

public class SimpleShield implements AmmunitionAble {

     @Override
     public String name() {
          return ViewConstant.SIMPLE_SHIELD;
     }

     @Override
     public int protect() {
          return 28;
     }
}
