package ua.external.lab.droids;

import ua.external.lab.repairable.RepairAble;
import ua.external.lab.weaponAndAmmunition.AmmunitionAble;
import ua.external.lab.weaponAndAmmunition.WeaponAble;

import java.io.Serializable;
import java.util.List;

public abstract class Droid implements Serializable {
    private int health;
    private int impact;
    private int protection;
    private String name;
    private int healthWithAmmunition;
    public RepairAble repairYourSelf;
    public  WeaponAble weapon;
    public  AmmunitionAble ammunition;

    public Droid(int[] arr, String name ) {
        this.health = arr[0];
        this.impact = arr[1];
        this.protection = arr[2];
        this.name = name;
    }

    public WeaponAble getWeapon() {
        return weapon;
    }

    public AmmunitionAble getAmmunition() {
        return ammunition;
    }

    public Droid setWeapon(WeaponAble weapon) {
        this.weapon = weapon;
        return this;
    }

    public String getWeaponName() {
        return weapon.name();
    }

    public int getWeaponImpact() {
        return weapon.impact();
    }

    public Droid setAmmunition(AmmunitionAble ammunition) {
        this.ammunition= ammunition;
        return this;
    }

    public String getAmmunitionName() {
        return ammunition.name();
    }

    public int getAmmunitionProtect() {
        return ammunition.protect();
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public Droid setHealth(int health) {
        this.health = health;
        return this;
    }

    public int getImpact() {
        return impact;
    }

    public Droid setImpact(int impact) {
        this.impact = impact;
        return this;
    }

    public int getProtection() {
        return protection;
    }

    public Droid setProtection(int protection) {
        this.protection = protection;
        return this;
    }

    public int getHealthWithAmmunition() {
        return healthWithAmmunition;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "health=" + health +
                ", impact=" + impact +
                ", protection=" + protection +
                ", name='" + name + '\'' +
                '}';
    }

    public void saveHealth(){
        healthWithAmmunition = health;
    }

    public int repair(){
       return repairYourSelf.repair();
    }
}
