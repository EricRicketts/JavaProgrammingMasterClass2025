package org.example;

import java.time.LocalDate;
import java.time.Period;

public class Worker {

    protected String name, birthDate, endDate;

    public Worker() {
        this.name = "Anonymous";
        this.birthDate = "No Birth Date";
        this.endDate = "No End Date";
    }

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        String[] parseBirthDateArray = birthDate.split("/");
        int month = Integer.parseInt(parseBirthDateArray[0]);
        int day = Integer.parseInt(parseBirthDateArray[1]);
        int year = Integer.parseInt(parseBirthDateArray[2]);
        LocalDate formattedBirthDate = LocalDate.of(year, month, day);
        Period age = Period.between(formattedBirthDate, currentDate);
        return age.getYears();
    }

    public double collectPay() {
        // monthly pay
        return 8_000.56;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }
}
