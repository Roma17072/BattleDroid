package ua.external.lab.droids;

import java.util.ArrayList;
import java.util.List;

abstract class Droid {
    private int health;
    private int impact;
    private int protection;
    private String name;
    private int healthWithAmmunition;
    RepairAble repairYourSelf;

    public Droid(int[] arr, String name ) {
        this.health = arr[0];
        this.impact = arr[1];
        this.protection = arr[2];
        this.name = name;
    }
    abstract void WeaponsAndAmmunition();

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
        return " {" + "health=" + health +
                ", impact=" + impact +
                ", protection=" + protection +
                '}';
    }

    public void saveHealth(){
        healthWithAmmunition = health;
    }

    public abstract List<String> getListWeaponsAndAmmunition();

    public int repair(){
       return repairYourSelf.repair();
    }
}
