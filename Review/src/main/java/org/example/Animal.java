package org.example;

public class Animal {

    public enum Size {
        SMALL, MEDIUM, LARGE, EXTRA_LARGE
    }
    private static final String NAME_IS_NULL =
        "A null value is not allowed for a name.";

    private static final String NAME_IS_EMPTY =
        "An empty value is not allowed for a name.";

    private static final String NAME_IS_BLANK =
        "A blank value is not allowed for a name.";

    private String name;

    private Size size;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public Animal(String name, Size size) {
        this.name = validateName(name);
        this.size = size;
    }

    public Animal(String name) {
        this(name, Size.MEDIUM);
    }

    public Animal() {
        this("Unknown Animal", Size.MEDIUM);
    }

    public String makeSound() {
        return "Generic animal sound";
    }

    private String validateName(String name) {
        if (name == null) {
            throw new NullPointerException(NAME_IS_NULL);
        } else if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_IS_EMPTY);
        } else if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_IS_BLANK);
        } else {
            return name;
        }
    }
}
