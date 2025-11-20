package GradeBookApp;
/*
 * Course: CIS 505 Intermediate Java Programming
 * Name: Jarrett Nobles
 * Assignment: 11.2 GradeBookApp – Event Handling
 * File: Student.java
 * Description: Student class used by the GradeBookApp.
 */

public class Student {

    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Override toString() to display the student in the results area
    @Override
    public String toString() {
        return String.format("%s %s - %s (%s)",
                firstName,
                lastName,
                course,
                grade);
    }
}
