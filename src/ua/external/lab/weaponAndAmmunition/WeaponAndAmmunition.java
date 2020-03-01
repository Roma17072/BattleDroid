package ua.external.lab.weaponAndAmmunition;

import ua.external.lab.droids.Droid;

public class WeaponAndAmmunition  {
    //Weapon factory
    public void weapon (Droid droid, int i){
        if(i!=5) {
            switch (i) {
                case 1:
                    droid.setWeapon(new Knife());
                    break;
                case 2:
                    droid.setWeapon(new Blaster());
                    break;
                case 3:
                    droid.setWeapon(new LaserBlaster());
                    break;
                case 4:
                    droid.setWeapon(new RocketBlaster());
                    break;
            }
            droid.setImpact(droid.getImpact()+droid.getWeaponImpact());
        }
    }
    //ammunition factory
    public void ammunition (Droid droid, int i) {
        if(i!=5) {
            switch (i) {
                case 1:
                    droid.setAmmunition(new ProtectiveVest());
                    break;
                case 2:
                    droid.setAmmunition(new Shield());
                    break;
                case 3:
                    droid.setAmmunition(new SimpleShield());
                    break;
                case 4:
                    droid.setAmmunition(new ArmoredShield());
                    break;
            }
            droid.setProtection(droid.getProtection() + droid.getAmmunitionProtect());
            droid.saveHealth();
        }else{
            droid.saveHealth();
        }
    }
}
