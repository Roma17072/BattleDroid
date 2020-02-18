package ua.external.lab.droids;

public class BattleDroidModel {
//Droid Factory
    public Droid chooseDroids(int i) {
        int n = (int) (1 + Math.random() * 4);
        switch (n) {
            case 1:
                return new Junior(Description.descriptionJuniorDroid, "Junior" + i);
            case 2:
                return new SimpleDroid(Description.descriptionSimpleDroid, "Simple Droid" + i);
            case 3:
                return new CombatantDroid(Description.descriptionCombatantDroid, "CombatantDroid" + i);
            case 4:
                return new Terminator(Description.descriptionTerminator, "Terminator" + i);
        }
        return null;
    }

    public void droidAttack(Droid first, Droid second) {
            if (second.getProtection() > 0) {
                second.setProtection(second.getProtection() - first.getImpact());
            } else {
                second.setHealth(second.getHealth() - first.getImpact());
            }
            if (second.getProtection() < 0) {
                second.setHealth(second.getHealth() + second.getProtection());
                second.setProtection(0);
            }if(second.getHealth() <= 0){
                second.setHealth(0);
        }
    }

    public String checkWinner(Droid first, Droid second){
        if (first.getHealth() <= 0) {
            return second.getName();
        }else if (second.getHealth() <= 0) {
            return first.getName();
        }else{
            return "continue";
        }
    }
    public int repairDroid(Droid droid) {
        if (droid.getHealth() != 0 && droid.getProtection() == 0 && droid.repair() !=0) {
            if((droid.getHealthWithAmmunition() - droid.getHealth()) >= droid.repairYourSelf.repair()){
                droid.setHealth(droid.getHealth() + droid.repair());
                return droid.repair();
            }else {
                int result = droid.getHealthWithAmmunition() - droid.getHealth();
                        droid.setHealth(droid.getHealthWithAmmunition());
                return result;
            }
        }else
            return 0;
    }
}


