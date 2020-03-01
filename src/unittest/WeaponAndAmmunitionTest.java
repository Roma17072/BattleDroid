package unittest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ua.external.lab.droids.Droid;
import ua.external.lab.weaponAndAmmunition.WeaponAndAmmunition;

class WeaponAndAmmunitionTest {
    WeaponAndAmmunition test = new WeaponAndAmmunition();
    Droid droid =new Droid(new int[]{0, 0, 0}, "Droid") {};

    @Test
    void weaponDroidAndKnife() {
        int expected = 12;
        test.weapon(droid,1);
        int actual = droid.getImpact();
        Assert.assertEquals(expected, actual);
    }
    @Test
    void weaponDroidAndBlaster() {
        int expected = 15;
        test.weapon(droid,2);
        int actual = droid.getImpact();
        Assert.assertEquals(expected, actual);
    }
    @Test
    void weaponDroidAndLaser() {
        int expected = 17;
        test.weapon(droid,3);
        int actual = droid.getImpact();
        Assert.assertEquals(expected, actual);
    }
    @Test
    void WithoutWeapon() {
        int expected = 0;
        test.weapon(droid,5);
        int actual = droid.getImpact();
        Assert.assertEquals(expected, actual);
    }
    @Test
    void ammunitionProtectiveVest() {
        int expected = 26;
        test.ammunition(droid,1);
        int actual = droid.getProtection();
        Assert.assertEquals(expected, actual);
    }
    @Test
    void ammunitionShield() {
        int expected = 23;
        test.ammunition(droid,2);
        int actual = droid.getProtection();
        Assert.assertEquals(expected, actual);
    }
    @Test
    void ammunitionArmoredShield() {
        int expected = 31;
        test.ammunition(droid,4);
        int actual = droid.getProtection();
        Assert.assertEquals(expected, actual);
    }
    @Test
    void WithoutAmmunition() {
        int expected = 0;
        test.ammunition(droid,5);
        int actual = droid.getProtection();
        Assert.assertEquals(expected, actual);
    }
}