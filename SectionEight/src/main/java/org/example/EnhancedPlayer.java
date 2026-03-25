package org.example;

public class EnhancedPlayer {

    /*
        In contrast to the Player class, the attributes are all private.  Therefore, the only
        to edit the values outside the class itself is to use methods to do so.  This means
        the methods will be in control of editing the values for the fields, thus encapsulating
        the changes.

        I changed the name attribute to fullName and the health attribute to healthPercentage, all
        tests ran without madification.  As noted by the instructor, if attributes are encapsulated,
        then changes do not affect existing code.  The EnhancedPlayer class has full control over
        its data as the attributes are private and can only by edited by running the methods defined
        in the class.

        To enforce encapsulation within a class:
            1.  Create constructors for object initialization, which ensures only objects with
            valid data will be created.
            2.  Use the private access modifier for your fields.
            3.  Sparing use of setter methods.
            4.  Use access modifiers that are not private only that the calling code needs to
            use.
    */
    private final String fullName;
    private final String weapon;
    private int healthPercentage;

    public EnhancedPlayer(String name) {
        this(name, 100, "Sword");
    }

    public EnhancedPlayer(String fullName, int health, String weapon) {
        /*
            We have not put in any checks for the state of the fullName and weapon, but
            a check was put in for the health state.  We can now be guaranteed the health
            of the player is initialized correctly in the constructor.
        */
        this.fullName = fullName;
        this.weapon = weapon;
        this.healthPercentage = (health <= 0) ? 1 : Math.min(health, 100);
    }

    public String looseHealth(int damage) {
        String healthString = "The player's health is sufficient to remain in the game.";
        this.healthPercentage = this.healthPercentage - damage;
        if (this.healthPercentage < 0) {
            healthString = "The player's health has caused his removal from the game.";
        }
        return healthString;
    }

    public int healthRemaining() {
        return this.healthPercentage;
    }

    public void restoreHealth(int extraHealth) {
        this.healthPercentage = this.healthPercentage + extraHealth;
        if (this.healthPercentage > 100) this.healthPercentage = 100;
    }

    public String getFullName() {
        return fullName;
    }

    public String getWeapon() {
        return weapon;
    }
}
