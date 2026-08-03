package org.example;

public class Student implements Comparable<Student> {

    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student name is " + name + ".  Student id is " + id + ".";
    }

    @Override
    public int compareTo(Student other) {
        int nameComparisonResult = this.getName().compareTo(other.getName());
        if (nameComparisonResult != 0) {
            return nameComparisonResult;
        }
        return Integer.compare(this.getId(), other.getId());
    }
}
