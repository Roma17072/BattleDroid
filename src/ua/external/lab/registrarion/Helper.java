package ua.external.lab.registrarion;
import java.io.*;
import java.util.Arrays;


public class Helper {
    static final String filename =  "RESOURCE/profile.csv";
    public static boolean checkLogin(String text) throws IOException {
        BufferedReader reader =new BufferedReader(new FileReader(filename ));
        while (reader.ready()) {
            String str = reader.readLine();
            String[] elements = str.split(";");
            if (elements[1].equals(text)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkUser(String [] user) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename ));
            while (reader.ready()) {
                String str = reader.readLine();
                String[] elements = str.split(";");
                if (Arrays.equals(elements, user)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

        public static void writeToFile(String role, String login,String password)  {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename,true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.write(role + ";");
        writer.write(login + ";");
        writer.write(password + ";\n");
        writer.flush();
        writer.close();
    }
}

