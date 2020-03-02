package ua.external.lab.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.external.lab.registrarion.MenuController;

import java.io.BufferedReader;
import java.io.IOException;

import static ua.external.lab.mvc.ViewBattleDroid.print;

public interface CheckInput {
    Logger logger1 = LogManager.getLogger(MenuController.class);

    static int checkInput(BufferedReader br) {
        int value = 0;
        do {
            try {
                value = Integer.parseInt(br.readLine());
                if (value > 2 || value < 1){
                    value = 0;
                    print(ViewBattleDroid.WRONG);
                    logger1.info("Input value more on less then limit");

                }
            } catch (NumberFormatException | IOException e) {
                print(ViewBattleDroid.WRONG);
                logger1.error("Input wrong value");
            }
        }while (value == 0);
        return value;
    }
}
