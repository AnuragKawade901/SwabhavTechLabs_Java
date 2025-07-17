package com.aurionpro.model.student;

public class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    public void getDetails() {
        System.out.println("User: " + username);
    }
}
