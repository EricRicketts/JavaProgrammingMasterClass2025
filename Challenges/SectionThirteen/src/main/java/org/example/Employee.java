package org.example;

import java.time.LocalDateTime;

public record Employee(
    String firstName,
    String lastName,
    LocalDateTime hireDateTime) {}
