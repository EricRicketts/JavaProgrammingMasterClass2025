package org.example;

public class Building implements Mappable {

    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UsageType getUsage() {
        return usage;
    }

    public void setUsage(UsageType usage) {
        this.usage = usage;
    }


    @Override
    public String getLabel() {
        return this.name + " (" + this.usage + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch(this.usage) {
            case CAFE -> Color.BROWN + " " + PointMarker.CIRCLE;
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarker.TRIANGLE;
            case FINANCE -> Color.RED + " " + PointMarker.DIAMOND;
            case GOVERNMENT -> Color.BLUE + " " + PointMarker.PUSH_PIN;
            case RESIDENTIAL -> Color.GRAY + " " + PointMarker.STAR;
            case RESTAURANT -> Color.ORANGE + " " + PointMarker.TEARDROP;
            case RETAIL -> Color.PURPLE + " " + PointMarker.SQUARE;
            case SPORTS -> Color.YELLOW + " " + PointMarker.ELLIPSE;
            default -> Color.BLACK + " " + PointMarker.RECTANGLE;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
            , "name": "%s", "usage": "%s"\s""".formatted(this.getName(), this.getUsage()).stripTrailing();
    }
}
