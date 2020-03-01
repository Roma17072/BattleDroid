package ua.external.lab.mvc;

import ua.external.lab.droids.Description;
import ua.external.lab.droids.Droid;
import ua.external.lab.droids.Junior;
import ua.external.lab.droids.SimpleDroid;
import ua.external.lab.serialize.SerializableAndDeserializable;
import ua.external.lab.serialize.SerializeToCSV;
import ua.external.lab.weaponAndAmmunition.Blaster;
import ua.external.lab.weaponAndAmmunition.ProtectiveVest;
import java.io.IOException;


public class DroidSerializable {
    public static void main(String[] args) throws IOException {
        Junior junior = new Junior(Description.descriptionJuniorDroid,"Junior");
        junior.saveHealth();
        junior.setWeapon(new Blaster());
        junior.setAmmunition(new ProtectiveVest());
        SerializableAndDeserializable.serialization(junior ,"Junior.dat");
        Droid jun = SerializableAndDeserializable.deserialization("Junior.dat");
        System.out.println(jun +" "+ jun.getWeaponName() + " " + jun.getAmmunitionName()
                            + " " + jun.repairYourSelf );
        System.out.println(jun.getClass().getSimpleName());

        SimpleDroid simple = new SimpleDroid(Description.descriptionSimpleDroid, "Simple");

        SerializeToCSV.writeToFile(simple, "droid.csv");
        Droid simpleDroid = SerializeToCSV.readFromFile("droid.csv");
        System.out.println(simpleDroid.getClass().getSimpleName());
        System.out.println(simpleDroid);

    }
}
