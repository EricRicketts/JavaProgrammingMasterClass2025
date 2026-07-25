package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private String weapon = "Sword";
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        String[] playerFeatures = new String[]{
            this.getName(),
            Integer.toString(this.getHitPoints()),
            Integer.toString(this.getStrength()),
            this.getWeapon()
        };

        return Arrays.asList(playerFeatures);
    }

    @Override
    public void read(List<String> playerFeatures) {
        String name = playerFeatures.getFirst();
        int hitPoints = Integer.parseInt(playerFeatures.get(1));
        int strength = Integer.parseInt(playerFeatures.get(2));
        String weapon = playerFeatures.getLast();

        this.setName(name);
        this.setHitPoints(hitPoints);
        this.setStrength(strength);
        this.setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'}"
            .formatted(this.getName(), this.getHitPoints(), this.getStrength(), this.getWeapon());
    }
}
