package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.Random;

public class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static final Random random = new Random();
    private int id;
    private BigDecimal gpa;
    private String lastName;
    private String firstName;

    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = LAST_ID;
        var gpaDouble = random.nextDouble(1.0, 4.0);
        this.gpa = BigDecimal.valueOf(gpaDouble).setScale(2, RoundingMode.HALF_UP);
    }

    public int getId() {
        return id;
    }

    public BigDecimal getGpa() {
        return gpa;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Student o) {
        int lastNameComparison = lastName.compareTo(o.lastName);
        if (lastNameComparison != 0) return lastNameComparison;

        int firstNameComparison = firstName.compareTo(o.firstName);
        if (firstNameComparison != 0) return firstNameComparison;

        int idComparison = Integer.compare(id, o.id);
        if (idComparison != 0) return idComparison;

        return gpa.compareTo(o.gpa);
    }
}
