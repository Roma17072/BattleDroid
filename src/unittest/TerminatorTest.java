package unittest;

import org.junit.Assert;
import org.junit.Test;
import ua.external.lab.droids.Description;
import ua.external.lab.droids.Terminator;
import static org.junit.Assert.*;

public class TerminatorTest {
    Terminator terminator  =new Terminator(Description.descriptionTerminator, "Terminator");

    @Test
    public void weaponsAndAmmunition() {
        int [] expected =  new int []{20,27,35};
        terminator.WeaponsAndAmmunition();
        int actual[] = {terminator.getHealth(),terminator.getImpact(),terminator.getProtection()};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void repairYourSelfTest(){
        int expected = 0;
        int actual = terminator.repair();
        Assert.assertEquals(expected,actual);
    }
}