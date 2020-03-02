package ua.external.lab.mvc;

import ua.external.lab.droids.*;
import java.util.Arrays;


public class DroidV6 {
    public static void main(String[] args) {
        Droid junior1 = new Junior(Description.descriptionJuniorDroid, "Junior");
        Droid simple = new SimpleDroid(Description.descriptionSimpleDroid, "Simple");
        Droid combatant = new CombatantDroid(Description.descriptionCombatantDroid, "Combatant");
        Droid terminator = new Terminator(Description.descriptionTerminator, "Terminator");
        Droid junior2 = new Junior(Description.descriptionJuniorDroid, "Junior");
        Droid simple2 = new SimpleDroid(Description.descriptionSimpleDroid, "Simple");
        Droid combatant2 = new CombatantDroid(Description.descriptionCombatantDroid, "Combatant");

        Droid[] mas = new Droid[7];
        mas[0]= junior1;
        mas[1]= simple;
        mas[2]= junior2;
        mas[3]= simple2;
        mas[4]= terminator;
        mas[5]= combatant;
        mas[6]= combatant2;

        int iLite = 0;
        liteDroid[] masLiteDroid = new liteDroid[4];

        System.out.println("masLite");
        for (int i = 0; i < mas.length ; i++) {
            if (mas[i] instanceof liteDroid) {
                masLiteDroid[iLite++] = (liteDroid) mas[i];
                System.out.println((masLiteDroid[iLite - 1]).getClass());
                System.out.println((masLiteDroid[iLite - 1]).range());
            }
        }
        System.out.println("masHeavy");
        HeavyDroid[] masHeavy = new HeavyDroid [3];
        int iHeavy = 0;
        for (int i = 0; i<mas.length; i++){
            if(mas [i] instanceof  HeavyDroid){
                masHeavy[iHeavy++] = (HeavyDroid) mas[i];
                System.out.println((masHeavy[iHeavy- 1]).getClass());
                System.out.println((masHeavy[iHeavy - 1]).range());
            }
        }

        System.out.println("\nSort droid of range");
        Arrays.sort(masLiteDroid, (o1, o2) ->  o2.range() - o1.range());
        System.out.println(Arrays.toString(masLiteDroid));

        System.out.println("\nSort droid of health");
        Arrays.sort(mas, (o1, o2) ->  o2.getHealth() - o1.getHealth());
        System.out.println(Arrays.toString(mas));

        System.out.println("\nFind lite droids with range1");
        for(int i = 0; i < masLiteDroid.length; i ++ ){
            if(masLiteDroid[i].range()==1){
                System.out.println(masLiteDroid[i].getClass());
                System.out.println(masLiteDroid[i].range());
            }
        }
    }
}
