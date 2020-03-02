package ua.external.lab.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.external.lab.droids.Droid;


public class UserController implements CheckInput {
    private ViewBattleDroid viewGameProcess;
    private BattleDroidModel modelImplementation;

    Logger logger1 = LogManager.getLogger(UserController.class);

    public UserController(ViewBattleDroid viewGameProcess, BattleDroidModel modelImplementation) {
        this.viewGameProcess = viewGameProcess;
        this.modelImplementation = modelImplementation;
    }

    public boolean processUser() {
        int i = 1;
        viewGameProcess.printMessage(ViewBattleDroid.WELCOME);
        Droid first = modelImplementation.getFirst();
        Droid second = modelImplementation.getSecond();
        if (first == null && second == null){
            viewGameProcess.printMessage(ViewBattleDroid.FAIL);
            logger1.error("Some of droids is null");
            return true;
        }
        viewGameProcess.printBattle(first, second);
        viewGameProcess.printParameters(first);
        printWeaponsAndAmmunition(first);
        viewGameProcess.printParameters(second);
        printWeaponsAndAmmunition(second);
        do{
            viewGameProcess.printRound(i);
            if (i%2 != 0) {
                attackController(first, second);
                repairDroid(second);
            }else {
                attackController(second, first);
                repairDroid(first);
            }
            i++;
        }while(modelImplementation.checkWinner(first,second).equals("continue"));
        viewGameProcess.printWinner(modelImplementation.checkWinner(first,second));
        return true;
    }

    public void attackController (Droid first, Droid second) {
        viewGameProcess.printAttackDroid(first);
        modelImplementation.droidAttack(first, second);
        viewGameProcess.printMessage(ViewConstant.DAMAGE);
        viewGameProcess.printParameters(second);
    }

    public void repairDroid(Droid droid){
        int resultRepair = modelImplementation.repairDroid(droid);
        if (resultRepair != 0){
            viewGameProcess.printRepair(droid, resultRepair);
            viewGameProcess.printParameters(droid);
        }
    }
    public void printWeaponsAndAmmunition(Droid droid){
        if(droid.getWeapon()!=null ||droid.getAmmunition()!=null) {
            viewGameProcess.printMessage(ViewConstant.WEAPONS_AND_AMMUNITION);
        }
        if(droid.getWeapon()!=null){
            viewGameProcess.printMessage(droid.getWeaponName());
        }
        if(droid.getAmmunition()!=null){
            viewGameProcess.printMessage(droid.getAmmunitionName());
        }
        viewGameProcess.print("\n");

    }
}
