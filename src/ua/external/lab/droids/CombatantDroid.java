package ua.external.lab.droids;

import ua.external.lab.repairable.SimpleRepair;
import ua.external.lab.weaponAndAmmunition.ArmoredShield;
import ua.external.lab.weaponAndAmmunition.LaserBlaster;

import java.util.ArrayList;
import java.util.List;

public class CombatantDroid extends Droid implements ArmoredShield, LaserBlaster {
    private List<String> listWeaponsAndAmmunition = new ArrayList<String>();

    public CombatantDroid(int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new SimpleRepair();
    }

    @Override
    public List<String> getListWeaponsAndAmmunition() {
        return listWeaponsAndAmmunition;
    }

    @Override
    public void WeaponsAndAmmunition() {
        setProtection(getProtection()+armoredShieldProtection);
        listWeaponsAndAmmunition.add(ArmoredShield.name);
        setImpact(getImpact()+laserBlasterImpact);
        listWeaponsAndAmmunition.add(LaserBlaster.name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
