package org.example;
import java.util.Objects;

public class NewStudent implements Comparable<NewStudent>, QueryItem {


        private String name;
        private String course;
        private int id;
        private int yearStarted;

        public NewStudent(String name, String course, int id, int yearStarted) {
            this.name = name;
            this.course = course;
            this.id = id;
            this.yearStarted = yearStarted;
        }

        public NewStudent() {
            this.name = "Foo Bar";
            this.course = "No Course";
            this.id = 0;
            this.yearStarted = 0;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getCourse() {
            return course;
        }

        public int getYearStarted() {
            return yearStarted;
        }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    @Override
        public String toString() {
            return "Student name is " + name + ".  Student id is " + id + ".";
        }

        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;
            if (!super.equals(object)) return false;
            NewStudent student = (NewStudent) object;
            return getId() == student.getId() &&
                getYearStarted() == student.getYearStarted() &&
                java.util.Objects.equals(getName(), student.getName()) &&
                java.util.Objects.equals(getCourse(), student.getCourse());
        }

        public int hashCode() {
            return Objects.hash(super.hashCode(), getName(), getCourse(), getId(), getYearStarted());
        }

        @Override
        public int compareTo(NewStudent other) {
            if (Integer.compare(this.getId(), other.getId()) != 0) {
                return Integer.compare(this.getId(), other.getId());
            };
            int nameComparisonResult = this.getName().compareTo(other.getName());
            if (nameComparisonResult != 0) {
                return nameComparisonResult;
            }
            int courseComparisonResult = this.getCourse().compareTo(other.getCourse());
            if (courseComparisonResult != 0) {
                return courseComparisonResult;
            }
            return Integer.compare(this.getYearStarted(), other.getYearStarted());
        }

        @Override
        public boolean matchFieldValue(String fieldName, String value) {
            String localFieldName = fieldName.toUpperCase();
            return switch (localFieldName) {
                case "NAME" -> this.getName().split("\\s+")[0].equalsIgnoreCase(value);
                case "COURSE" -> this.getCourse().equalsIgnoreCase(value);
                case "ID" -> this.getId() == Integer.parseInt(value);
                case "YEARSTARTED" -> this.getYearStarted() == Integer.parseInt(value);
                default -> false;
            };
        }
    }
