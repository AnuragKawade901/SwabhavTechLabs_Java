package com.aurionpro.model.student;

public class Admin extends User {
    public Admin(String username) {
        super(username);
    }

    @Override
    public void getDetails() {
        System.out.println("Admin: " + username);
    }
}