package org.example;

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UtilityType getType() {
        return type;
    }

    public void setType(UtilityType type) {
        this.type = type;
    }

    @Override
    public String getLabel() {
        return this.getName() + " (" + this.getType() + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch(this.getType()) {
            case ELECTRICAL -> Color.RED + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.GREEN + " " + LineMarker.DOTTED;
            case GAS -> Color.ORANGE + " " + LineMarker.DOT_DASH;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
            case WASTE_DISPOSAL -> Color.BROWN + " " + LineMarker.STRIPED;
            default -> Color.BLACK + " " + LineMarker.SOLID;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
            , "name": "%s", "utility": "%s"\s""".formatted(this.getName(), this.getType()).stripTrailing();
    }
}
