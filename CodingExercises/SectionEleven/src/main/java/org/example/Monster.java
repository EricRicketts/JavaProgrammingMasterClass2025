package org.example;

import java.util.Arrays;
import java.util.List;

public class Monster implements ISaveable {

    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        String[] monsterFeatures = new String[]{
            this.getName(),
            Integer.toString(this.getHitPoints()),
            Integer.toString(this.getStrength()),
        };

        return Arrays.asList(monsterFeatures);
    }

    @Override
    public void read(List<String> monsterFeatures) {
        String name = monsterFeatures.getFirst();
        int hitPoints = Integer.parseInt(monsterFeatures.get(1));
        int strength = Integer.parseInt(monsterFeatures.getLast());

        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Monster{name='%s', hitPoints=%d, strength=%d}"
            .formatted(this.getName(), this.getHitPoints(), this.getStrength());
    }
}
