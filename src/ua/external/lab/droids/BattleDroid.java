package ua.external.lab.droids;

public class BattleDroid {
    public static void main(String[] args) {
        System.out.println("Welcome to battle of Droids");
        BattleDroid battle = new BattleDroid();
        Droid first = battle.chooseDroids(1);
        Droid second = battle.chooseDroids(2);
        System.out.println("Base droids parameters:\n" + first +"\n" +second+ "\n");
        first.WeaponsAndAmmunition();
        second.WeaponsAndAmmunition();
        System.out.println(first.getName()+" droid weapon and ammunition" + first.getListWeaponsAndAmmunition()+ "\n"
        + second.getName()+ " droid weapon and ammunition"+ second.getListWeaponsAndAmmunition() + "\n");
        System.out.println("Final Droids parameters:\n"+ first +"\n" +second+ "\n");
        do {
            battle.droidAttack(first, second);
            battle.droidAttack(second, first);
        }while(first.getHealth()> 0 && second.getHealth() > 0);

       /* first.getHealth()> 0 && second.getHealth() > 0;
        if (first.getHealth() == 0 ){
            System.out.println(second.getName()+" win");
        }else
            System.out.println(first.getName()+" win");
        }*/
    }

    private void droidAttack (Droid first, Droid second){
        if (first.getHealth() > 0) {
            System.out.println(first.getName()+" droid attack");
            if (second.getProtection() > 0) {
                second.setProtection(second.getProtection() - first.getImpact());
            } else {
                second.setHealth(second.getHealth() - first.getImpact());
            }
                if (second.getProtection() < 0) {
                    second.setHealth(second.getHealth() + second.getProtection());
                    second.setProtection(0);
                }
                if(second.getHealth() <= 0){
                    System.out.println(first.getName()+" win");
                }
            System.out.println(second.getName() + " droid parameters:" + second);
            }
        }

    private Droid chooseDroids(int i) {
        int n = (int) (1 + Math.random() * 4);
        switch (n) {
            case 1:
                return new Junior(Description.descriptionJuniorDroid, "Junior"+i);
            case 2:
                return new SimpleDroid(Description.descriptionSimpleDroid, "Simple Droid"+i);
            case 3:
                return new CombatantDroid(Description.descriptionCombatantDroid, "CombatantDroid"+i);
            case 4:
                return new Terminator(Description.descriptionTerminator, "Terminator"+i);
        }
        return null;
    }
}






