package com.aurionpro.enumeration.model;

public class RoleTest {
    
    public void grantAccess(Role role) {
        switch (role) {
            case USER:
                System.out.println("only dashboard");
                break;

            case ADMIN:
                System.out.println("only user");
                break;

            case MANAGER:
                System.out.println("only everything");
                break;
        }
    }

    public static void main(String[] args) {
        RoleTest test = new RoleTest();  // Create an object to call non-static method
        test.grantAccess(Role.ADMIN);
        test.grantAccess(Role.MANAGER);
        test.grantAccess(Role.USER);
    }
}
