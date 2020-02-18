package ua.external.lab.droids;

public class BattleDroid {
    public static void main(String[] args) {
        BattleDroidModel modelImplementation = new BattleDroidModel();
        ViewBattleDroid viewGameProcess = new ViewBattleDroid();
        BattleDroidController battleController = new BattleDroidController(viewGameProcess, modelImplementation);
        battleController.processUser();
    }
}




