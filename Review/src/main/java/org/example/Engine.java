package org.example;

public record Engine(
    EngineType type,
    int horsepower,
    int torque
) {
}
