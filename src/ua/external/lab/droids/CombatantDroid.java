package ua.external.lab.droids;

import java.util.ArrayList;
import java.util.List;

public class CombatantDroid extends SimpleDroid implements ArmoredShield, LaserBlaster {
    private List<String> listWeaponsAndAmmunition = new ArrayList<String>();

    public CombatantDroid(int[] arr, String name) {
        super(arr, name);
    }

    @Override
    public List<String> getListWeaponsAndAmmunition() {
        return listWeaponsAndAmmunition;
    }

    @Override
    void WeaponsAndAmmunition() {
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
