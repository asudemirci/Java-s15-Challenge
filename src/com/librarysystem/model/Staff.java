package com.librarysystem.model;

public class Staff extends User {
    public Staff(int id, String name) {
        super(id, name);
    }

    @Override
    public String getUserType() {
        return "Staff";
    }
}
