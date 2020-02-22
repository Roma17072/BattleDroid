package ua.external.lab.droids;

public class UserController implements CheckInput {
    private ViewBattleDroid viewGameProcess;
    private BattleDroidModel modelImplementation;

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
            return true;
        }
        viewGameProcess.printBattle(first, second);
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
        viewGameProcess.printWinner(modelImplementation.checkWinner(first,second));
        return true;
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
