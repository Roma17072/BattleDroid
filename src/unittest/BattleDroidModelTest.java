package unittest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ua.external.lab.droids.BattleDroidModel;
import ua.external.lab.droids.Junior;
import ua.external.lab.droids.SimpleDroid;




class BattleDroidModelTest {
    int []arr;
    BattleDroidModel testModel = new BattleDroidModel();
    SimpleDroid simple = new SimpleDroid(arr = new int[]{35,17,20} ,"Simple");
    Junior junior = new Junior(arr = new int []{40,15,20}, "Junior");


    @Test
    public void chooseDroids() {
        Object actual = testModel.chooseDroids(1);
        int [] listActual  =  new int [] {junior.getHealth(),junior.getImpact(), junior.getProtection()};
        Object expected = junior;
        int []listExpected  = (new int[]{40,15,20});
        Assert.assertTrue(expected.getClass() == actual.getClass());
        Assert.assertArrayEquals(listExpected, listActual);
    }

    @Test
    void droidAttack() {
        testModel.droidAttack(simple, junior);
        int [] actual  =  new int [] {junior.getHealth(),junior.getImpact(), junior.getProtection()};
        int []expected  = (new int[]{40,15,3});
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    void checkWinner() {
        String actual = testModel.checkWinner(junior,simple);
        String expected = "continue";
        Assert.assertEquals(expected,actual);

        String actualJuniorWinner = testModel.checkWinner(junior,simple.setHealth(0));
        String expectedJuniorWinner ="Junior";
        Assert.assertEquals(expectedJuniorWinner,actualJuniorWinner);
    }

    @Test
    void repairDroid() {
        //repair is more then health
        junior.setProtection(0);
        junior.saveHealth();
        junior.setHealth(38);
        int actualJunior = testModel.repairDroid(junior);
        int expectedJunior = 2;
        Assert.assertEquals(expectedJunior,actualJunior);

        //repair is less then health

        simple.setProtection(0);
        simple.saveHealth();
        simple.setHealth(25);
        int actualSimple = testModel.repairDroid(simple);
        int expectedSimple = 5;
        Assert.assertEquals(expectedSimple,actualSimple);
    }
}