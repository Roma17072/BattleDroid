package ua.external.lab.registrarion;
import java.io.*;
import java.util.Arrays;

public class Helper {
    public boolean checkLogin(String text, int i) throws IOException {
        BufferedReader reader =new BufferedReader(new FileReader("password.csv"));
        while (reader.ready()) {
            String str = reader.readLine();
            String[] elements = str.split(";");
                if (elements[i].equals(text)) {
                    return false;
                }
        }
        return true;
    }

    public boolean checkUser(String [] user) throws IOException {
        BufferedReader reader =new BufferedReader(new FileReader("password.csv"));
        while (reader.ready()) {
            String str = reader.readLine();
            String[] elements = str.split(";");
            if (Arrays.equals(elements, user)) {
                return true;
            }
        }
        return false;
    }

    public void writeToFile(String profile, String login, String password)  {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("Password.csv",true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.write(profile + ";");
        writer.write(login + ";");
        writer.write(password + "\n");
        writer.flush();
        writer.close();
    }
}

