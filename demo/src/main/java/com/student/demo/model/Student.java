package com.student.demo.model;

public class Student {

    private int id;
    private String name;
    private String email;
    private String gradeLevel;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(int id, String name, String email, String gradeLevel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gradeLevel = gradeLevel;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for gradeLevel
    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}