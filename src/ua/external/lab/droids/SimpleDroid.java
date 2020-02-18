package ua.external.lab.droids;
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
    void WeaponsAndAmmunition() {
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
