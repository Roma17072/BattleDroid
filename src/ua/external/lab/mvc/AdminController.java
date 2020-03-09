package ua.external.lab.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.external.lab.droids.Description;
import ua.external.lab.weaponAndAmmunition.WeaponAndAmmunition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.external.lab.mvc.ViewBattleDroid.print;

public class AdminController implements CheckInput {
    private ViewBattleDroid viewGameProcess;
    private BattleDroidModel modelImplementation;
    private WeaponAndAmmunition weaponAndAmmunition;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int MAX_DROID = 4;
    final int MIN_DROID = 1;
    final int MAX_SELECT = 5;
    final int MIN_SELECT = 0;
    Logger logger1 = LogManager.getLogger(AdminController.class);

    public AdminController(ViewBattleDroid viewGameProcess, BattleDroidModel modelImplementation, WeaponAndAmmunition weaponAndAmmunition) {
        this.viewGameProcess = viewGameProcess;
        this.modelImplementation = modelImplementation;
        this.weaponAndAmmunition = weaponAndAmmunition;
    }

    public boolean processAdmin(){
        viewGameProcess.printMessageBundle(ViewBattleDroid.WELCOME);
        viewGameProcess.printBaseParameters("Junior", Description.descriptionJuniorDroid);
        viewGameProcess.printBaseParameters("Simple Droid", Description.descriptionSimpleDroid);
        viewGameProcess.printBaseParameters("Combatant Droid", Description.descriptionCombatantDroid);
        viewGameProcess.printBaseParameters("Terminator", Description.descriptionTerminator);
        viewGameProcess.print("\n");
        viewGameProcess.printMessageBundle(ViewBattleDroid.SELECT_OR_RANDOM);
        selectOrRandom(CheckInput.checkInput(br));
        return true;
    }

    private void selectOrRandom(int i){
        if(i==1){
            selectDroid();
        }else{
            modelImplementation.setFirst(modelImplementation.chooseDroids((int) (MIN_DROID + Math.random() * MAX_DROID)));
            weaponAndAmmunition.weapon(modelImplementation.getFirst(),((int) (MIN_DROID + Math.random() * MAX_DROID)));
            weaponAndAmmunition.ammunition(modelImplementation.getFirst(),((int) (MIN_DROID + Math.random() * MAX_DROID)));
            modelImplementation.setSecond(modelImplementation.chooseDroids((int) (MIN_DROID + Math.random() * MAX_DROID)));
            weaponAndAmmunition.weapon(modelImplementation.getSecond(),((int) (MIN_DROID + Math.random() * MAX_DROID)));
            weaponAndAmmunition.ammunition(modelImplementation.getSecond(),((int) (MIN_DROID + Math.random() * MAX_DROID)));
        }
    }

    private void selectDroid(){
        viewGameProcess.printChooseDroids(ViewConstant.FIRST);
        modelImplementation.setFirst(modelImplementation.chooseDroids(check(br, MIN_DROID, MAX_DROID)));
        viewGameProcess.printMessageBundle(ViewBattleDroid.SELECT_WEAPON);
        weaponAndAmmunition.weapon(modelImplementation.getFirst(),check(br,MIN_SELECT, MAX_SELECT));
        viewGameProcess.printMessageBundle(ViewBattleDroid.SELECT_AMMUNITION);
        weaponAndAmmunition.ammunition(modelImplementation.getFirst(),check(br,MIN_SELECT, MAX_SELECT));
        viewGameProcess.printChooseDroids(ViewConstant.SECOND);
        modelImplementation.setSecond(modelImplementation.chooseDroids(check(br, MIN_DROID, MAX_DROID)));
        viewGameProcess.printMessageBundle(ViewBattleDroid.SELECT_WEAPON);
        weaponAndAmmunition.weapon(modelImplementation.getSecond(),check(br,MIN_SELECT, MAX_SELECT));
        viewGameProcess.printMessageBundle(ViewBattleDroid.SELECT_AMMUNITION);
        weaponAndAmmunition.ammunition(modelImplementation.getSecond(),check(br,MIN_SELECT, MAX_SELECT));
    }

    public int check(BufferedReader br,int min ,int max) {
        int value = 0;
        do {
            try {
                value = Integer.parseInt(br.readLine());
                if (value > max || value < min){
                    logger1.info("Input value more on less then limit",value);
                    value = 0;
                    print(ViewBattleDroid.WRONG);

                }
            } catch (NumberFormatException | IOException e) {
                print(ViewBattleDroid.WRONG);
                logger1.error("Wrong input format ",e);
            }
        }while (value == 0);
        return value;
    }
}

