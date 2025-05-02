package com.librarysystem.model;

public class Student extends User {
    public Student(int id, String name) {
        super(id, name);
    }

    @Override
    public String getUserType() {
        return "Student";
    }
}
