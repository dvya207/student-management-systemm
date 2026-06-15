package com.student.demo.model;

public class Student {

    private int id;
    private String name;
    private String gradeLevel;
    private String email;

    public Student() {
    }

    public Student(int id, String name, String gradeLevel, String email) {
        this.id = id;
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}