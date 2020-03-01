package unittest;

import org.junit.Assert;
import org.junit.Test;
import ua.external.lab.droids.CombatantDroid;
import ua.external.lab.droids.Description;


import static org.junit.Assert.*;

public class CombatantDroidTest {
    CombatantDroid combatantDroid =new CombatantDroid(Description.descriptionCombatantDroid, "Combatant Droid");

    @Test
    public void repairYourSelfTest(){
        int expected = 5;
        int actual = combatantDroid.repair();
        Assert.assertEquals(expected,actual);
    }

}