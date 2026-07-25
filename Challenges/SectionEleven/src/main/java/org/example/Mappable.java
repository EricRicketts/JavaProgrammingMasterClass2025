package org.example;

public interface Mappable {

    final String JSON_PROPERTY = """
        "properties": {%s}""";

    String getLabel();

    Geometry getShape();

    String getMarker();

    static String mapIt(Mappable mappable) {
        return JSON_PROPERTY.formatted(mappable.toJSON());
    }

    default String toJSON() {
        return """
            "type": "%s", "label": "%s", "marker": "%s"\s"""
            .formatted(this.getShape(), this.getLabel(), this.getMarker());
    }
}
