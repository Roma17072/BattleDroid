package ua.external.lab.droids;

public class BattleDroidController {
    private ViewBattleDroid viewGameProcess;
    private BattleDroidModel modelImplementation;

    public BattleDroidController(ViewBattleDroid viewGameProcess, BattleDroidModel modelImplementation) {
        this.viewGameProcess = viewGameProcess;
        this.modelImplementation = modelImplementation;
    }

    public void processUser() {
        int i = 1;
        viewGameProcess.printMessage(ViewBattleDroid.WELCOME);
        Droid first = modelImplementation.chooseDroids(1);
        Droid second = modelImplementation.chooseDroids(2);
        viewGameProcess.printBaseParameters(first, second);
        first.WeaponsAndAmmunition();
        first.saveHealth();
        second.WeaponsAndAmmunition();
        second.saveHealth();
        viewGameProcess.printWeaponsAndAmmunition(first, second);
        viewGameProcess.printFinalParameters(first, second);
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
        viewGameProcess.printMessage("\n"+modelImplementation.checkWinner(first,second)+ ViewBattleDroid.WIN+":)");

    }

    public void attackController (Droid first, Droid second) {
        viewGameProcess.printAttackDroid(first);
        modelImplementation.droidAttack(first, second);
        viewGameProcess.printInjuries(second);
    }
    public void repairDroid(Droid droid){
        int resultRepair = modelImplementation.repairDroid(droid);
        if (resultRepair != 0){
            viewGameProcess.printRepair(droid, resultRepair);
            viewGameProcess.printParameters(droid);
        }
    }
}
