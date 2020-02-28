package unittest;

import org.junit.Assert;
import org.junit.Test;
import ua.external.lab.droids.Description;
import ua.external.lab.droids.Junior;

import static org.junit.Assert.*;

public class JuniorTest {
    Junior junior =new Junior(Description.descriptionJuniorDroid, "Junior");

    @Test
    public void weaponsAndAmmunition() {
        int [] expected =  new int []{40,18,25};
        junior.WeaponsAndAmmunition();
        int actual[] = {junior.getHealth(),junior.getImpact(),junior.getProtection()};
        Assert.assertArrayEquals(expected,actual);
    }
    @Test
    public void repairYourSelfTest(){
        int expected = 7;
        int actual = junior.repair();
        Assert.assertEquals(expected,actual);
    }
}
