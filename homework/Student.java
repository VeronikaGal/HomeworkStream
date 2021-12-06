package com.galeeva.lesson21.homework;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String firstName;
    private final String lastName;
    private final int numberCourse;
    private List<Integer> marks = new ArrayList<>();

    public Student(String firstName, String lastName, int numberCourse, List<Integer> marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberCourse = numberCourse;
        this.marks = marks;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberCourse=" + numberCourse +
                ", marks=" + marks +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberCourse() {
        return numberCourse;
    }

    public List<Integer> getMarks() {
        return marks;
    }
}
