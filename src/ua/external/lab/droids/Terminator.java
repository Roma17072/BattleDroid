package ua.external.lab.droids;

import java.util.ArrayList;
import java.util.List;

public class Terminator extends CombatantDroid implements RocketBlaster, ArmoredShield {
    private List<String> listWeaponsAndAmmunition = new ArrayList<String>();

    public Terminator(int[] arr, String name) {
        super(arr, name);
    }

    public List<String> getListWeaponsAndAmmunition() {
        return listWeaponsAndAmmunition;
    }

    @Override
    void WeaponsAndAmmunition() {
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
