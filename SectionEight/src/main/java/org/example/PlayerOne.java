package org.example;

public class PlayerOne {
    // Non-encapsulated example of a class.
    public String name;
    public int health;
    public String weapon;

    public String looseHealth(int damage) {
        String healthString = "The player's health is sufficient to remain in the game.";
        this.health = this.health - damage;
        if (this.health < 0) {
            healthString = "The player's health has caused his removal from the game.";
        }
        return healthString;
    }

    public int healthRemaining() {
        return this.health;
    }

    public void restoreHealth(int extraHealth) {
        this.health = this.health + extraHealth;
        if (this.health > 100) this.health = 100;
    }
}
