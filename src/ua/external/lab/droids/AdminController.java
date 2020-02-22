package ua.external.lab.droids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.external.lab.droids.ViewBattleDroid.print;

public class AdminController implements CheckInput {
    private ViewBattleDroid viewGameProcess;
    private BattleDroidModel modelImplementation;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public AdminController(ViewBattleDroid viewGameProcess, BattleDroidModel modelImplementation) {
        this.viewGameProcess = viewGameProcess;
        this.modelImplementation = modelImplementation;
    }
    public boolean processAdmin(){
        viewGameProcess.printMessage(ViewBattleDroid.WELCOME);
        viewGameProcess.printMessage(ViewBattleDroid.SELECT_OR_RANDOM);
        selectOrRandom(CheckInput.checkInput(br));
        return true;
    }
    private void selectOrRandom(int i){
        int n;
        if(i==1){
            selectDroid();
        }else{
            modelImplementation.setFirst(modelImplementation.chooseDroids(n = (int) (1 + Math.random() * 4)));
            modelImplementation.setSecond(modelImplementation.chooseDroids(n = (int) (1 + Math.random() * 4)));
        }
    }

    private void selectDroid(){
        viewGameProcess.printChooseDroids("first");
        modelImplementation.setFirst(modelImplementation.chooseDroids(check(br)));
        viewGameProcess.printChooseDroids("second");
        modelImplementation.setSecond(modelImplementation.chooseDroids(check(br)));
    }
    public int check(BufferedReader br) {
        int value = 0;
        do {
            try {
                value = Integer.parseInt(br.readLine());
                if (value > 4 || value < 1){
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

