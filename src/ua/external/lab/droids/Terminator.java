package ua.external.lab.droids;

import ua.external.lab.repairable.NotRepair;
import ua.external.lab.weaponAndAmmunition.ArmoredShield;
import ua.external.lab.weaponAndAmmunition.RocketBlaster;

import java.util.ArrayList;
import java.util.List;

public class Terminator extends Droid implements RocketBlaster, ArmoredShield {
    private List<String> listWeaponsAndAmmunition = new ArrayList<String>();

    public Terminator(int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new NotRepair();
    }

    public List<String> getListWeaponsAndAmmunition() {
        return listWeaponsAndAmmunition;
    }

    @Override
    public void WeaponsAndAmmunition() {
        setProtection(getProtection()+armoredShieldProtection);
        listWeaponsAndAmmunition.add(ArmoredShield.name);
        setImpact(getImpact()+rocketBlasterImpact);
        listWeaponsAndAmmunition.add(RocketBlaster.name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
