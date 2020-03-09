package ua.external.lab.serialize;

import ua.external.lab.droids.CombatantDroid;
import ua.external.lab.droids.Droid;
import ua.external.lab.droids.Junior;
import ua.external.lab.droids.SimpleDroid;
import ua.external.lab.droids.Terminator;

import java.io.*;

public class SerializeToCSV {
    public static void writeToFile( Droid droid, String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));
        String droidClass = (droid.getClass().getSimpleName());
        writer.write(droidClass + ";"+ droid.getHealth()+ ";"+droid.getImpact()+ ";"
                + droid.getProtection()+ ";"+ droid.getName());
        writer.flush();
        writer.close();
    }
    public static Droid deserializeFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str = reader.readLine();
        String[] elems = str.split(";");
        int arr []= new int[]{Integer.parseInt(elems[1]), Integer.parseInt(elems[2]),Integer.parseInt(elems[3])};
        switch (elems[0]){
            case "SimpleDroid":
                return new SimpleDroid(arr,elems[4]);
            case "Junior":
                return new Junior(arr,elems[4]);
            case "CombatantDroid":
                return new CombatantDroid(arr,elems[4]);
            case "Terminator":
                return new Terminator(arr,elems[4]);
        }
        return null;
    }
}
