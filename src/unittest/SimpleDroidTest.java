package unittest;

import org.junit.Assert;
import org.junit.Test;
import ua.external.lab.droids.Description;
import ua.external.lab.droids.SimpleDroid;


import static org.junit.Assert.*;

public class SimpleDroidTest {
    SimpleDroid simpleDroid  =new SimpleDroid(Description.descriptionSimpleDroid, "Simple Droid");

    @Test
    public void weaponsAndAmmunition() {
        int [] expected =  new int []{35,22,25};
        simpleDroid.WeaponsAndAmmunition();
        int actual[] = {simpleDroid.getHealth(),simpleDroid.getImpact(),simpleDroid.getProtection()};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void repairYourSelfTest(){
        int expected = 5;
        int actual = simpleDroid.repair();
        Assert.assertEquals(expected,actual);
    }
}

