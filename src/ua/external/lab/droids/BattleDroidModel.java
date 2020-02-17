package ua.external.lab.droids;

public class BattleDroidModel {

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
}


