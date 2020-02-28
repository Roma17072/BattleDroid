package ua.external.lab.droids;
import ua.external.lab.repairable.SimpleRepair;
import ua.external.lab.weaponAndAmmunition.LaserBlaster;
import ua.external.lab.weaponAndAmmunition.SimpleShield;

import java.util.ArrayList;
import java.util.List;

public class SimpleDroid extends Droid implements SimpleShield, LaserBlaster {
    private List<String> listWeaponsAndAmmunition = new ArrayList<String>();

    public SimpleDroid (int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new SimpleRepair();
    }

    @Override
    public List<String> getListWeaponsAndAmmunition() {
        return listWeaponsAndAmmunition;
    }


    @Override
    public void WeaponsAndAmmunition() {
        setProtection(getProtection()+simpleShieldProtection);
        listWeaponsAndAmmunition.add(SimpleShield.name);
        setImpact(getImpact()+laserBlasterImpact);
        listWeaponsAndAmmunition.add(LaserBlaster.name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
