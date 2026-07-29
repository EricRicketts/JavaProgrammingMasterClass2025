package org.example;

public record Affiliation(String name, String type, String countryCode) {

    @Override
    public String toString() {
        return this.name + " (" + this.type + " in " + this.countryCode + ")";
    }
}
