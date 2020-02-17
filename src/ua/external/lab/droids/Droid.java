package ua.external.lab.droids;

import java.util.ArrayList;
import java.util.List;

abstract class Droid {
    private int health;
    private int impact;
    private int protection;
    private String name;

    abstract void WeaponsAndAmmunition();

    public Droid(int arr [], String name ) {
        this.health = arr[0];
        this.impact = arr[1];
        this.protection = arr[2];
        this.name = name;
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

    @Override
    public String toString() {
        return "Name " +name +
                " {" + "health=" + health +
                ", impact=" + impact +
                ", protection=" + protection +
                '}';
    }

    public abstract List<String> getListWeaponsAndAmmunition();


}
