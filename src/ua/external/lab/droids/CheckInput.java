package ua.external.lab.droids;
import java.io.BufferedReader;
import java.io.IOException;
import static ua.external.lab.droids.ViewBattleDroid.print;

public interface CheckInput {
    static int checkInput(BufferedReader br) {
        int value = 0;
        do {
            try {
                value = Integer.parseInt(br.readLine());
                if (value > 2 || value < 1){
                    value = 0;
                    print(ViewBattleDroid.WRONG);
                }
            } catch (NumberFormatException | IOException e) {
                print(ViewBattleDroid.WRONG);
            }
        }while (value == 0);
        return value;
    }
}
