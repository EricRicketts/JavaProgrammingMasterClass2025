package org.example;

public class UtilityLine {

    private String name;
    private Utility type;

    public UtilityLine(String name, Utility type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Utility getType() {
        return type;
    }

    public void setType(Utility type) {
        this.type = type;
    }
}
