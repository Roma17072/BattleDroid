package ua.external.lab.serialize;

import ua.external.lab.droids.Droid;

import java.io.*;

public class SerializableAndDeserializable {
    public static boolean serialization(Droid droid, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(droid);
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("Файл не может быть создан: " + e);
        } catch (NotSerializableException e) {
            System.err.println("Класс не поддерживает сериализацию: " + e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return false;
    }

    public static Droid deserialization(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Droid droid = (Droid) ois.readObject();
            return droid;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}



