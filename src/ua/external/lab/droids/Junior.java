package ua.external.lab.droids;

import java.util.ArrayList;
import java.util.List;

public class Junior extends Droid implements SimpleShield, Blaster {



    private List<String> listWeaponsAndAmmunition = new ArrayList<String>();

    public Junior(int[] arr, String name) {
        super(arr, name);
        repairYourSelf = new SuperRepair();
    }

    @Override
    public List<String> getListWeaponsAndAmmunition() {
        return listWeaponsAndAmmunition;
    }

    @Override
    void WeaponsAndAmmunition() {
        setImpact(getImpact()+blasterImpact);
        listWeaponsAndAmmunition.add(Blaster.name);
        setProtection(getProtection()+simpleShieldProtection);
        listWeaponsAndAmmunition.add(SimpleShield.name);
    }



    @Override
    public String toString() {
        return  super.toString();
    }
}
