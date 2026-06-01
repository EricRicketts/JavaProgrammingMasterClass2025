package org.example;

public class Animal {

    private static final String NAME_IS_NULL =
        "A null value is not allowed for a name.";

    private static final String NAME_IS_EMPTY =
        "An empty value is not allowed for a name.";

    private static final String NAME_IS_BLANK =
        "A blank value is not allowed for a name.";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public Animal(String name) {
        this.name = validateName(name);
    }

    public Animal() {
        this("Unknown Animal");
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
