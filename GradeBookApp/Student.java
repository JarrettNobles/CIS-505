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
    }//end default constructor

    // Parameterized constructor
    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    }//end constructor

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }//end getFirstName

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//end setFirstName

    public String getLastName() {
        return lastName;
    }//end getLastName

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//end setLastName

    public String getCourse() {
        return course;
    }//end getCourse

    public void setCourse(String course) {
        this.course = course;
    }//end setCourse

    public String getGrade() {
        return grade;
    }//end getGrade

    public void setGrade(String grade) {
        this.grade = grade;
    }//end setGrade

    // Override toString() to display the student in the results area
    @Override
    public String toString() {
        return String.format("%s %s - %s (%s)",
                firstName,
                lastName,
                course,
                grade);
    }//end toString
}//end Student
