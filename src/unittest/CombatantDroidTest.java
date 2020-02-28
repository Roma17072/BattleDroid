package unittest;

import org.junit.Assert;
import org.junit.Test;
import ua.external.lab.droids.CombatantDroid;
import ua.external.lab.droids.Description;


import static org.junit.Assert.*;

public class CombatantDroidTest {
    CombatantDroid combatantDroid =new CombatantDroid(Description.descriptionCombatantDroid, "Combatant Droid");

    @Test
    public void weaponsAndAmmunition() {
        int [] expected =  new int []{30,22,25};
        combatantDroid.WeaponsAndAmmunition();
        int actual[] = {combatantDroid.getHealth(), combatantDroid.getImpact(), combatantDroid.getProtection()};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void repairYourSelfTest(){
        int expected = 5;
        int actual = combatantDroid.repair();
        Assert.assertEquals(expected,actual);
    }

}