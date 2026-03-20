package org.example;

public class Student {
    /*
        Having to add the Getter and Setter methods adds a lot of code to the POJO.
        In the next lesson Records are introduced to reduce the amount of code
        for POJOs.  This code is called "boilerplate code" as it is repetitive code
        that follows certain rules.
    */
    private String id, name, dateOfBirth, classList;

    public Student(String id, String name, String dateOfBirth, String classList) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.classList = classList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getClassList() {
        return classList;
    }

    public void setClassList(String classList) {
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", dateOfBirth='" + this.dateOfBirth + '\'' +
                ", classList='" + this.classList + '\'' +
                '}';
    }
}
