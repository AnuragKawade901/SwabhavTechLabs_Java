package com.aurionpro.BankingMP.model;

import java.sql.SQLException;

public class BankController {
    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
        	System.out.println("-----Welcome to SBJ Bank-----");
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int option = InputUtil.getValidInt("Choose option: ");
            try {
                switch (option) {
                    case 1 -> handleCreate();
                    case 2 -> handleLogin();
                    case 3 -> handleExit();
                   
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    
    private void handleExit() throws SQLException {
        String choice;
        do {
            choice = InputUtil.getString("Are you sure you want to Exit? (Y/N): ").trim().toUpperCase();
            if (!choice.equals("Y") && !choice.equals("N")) {
                System.out.println("❌ Invalid input. Please enter Y or N only.");
            }
        } while (!choice.equals("Y") && !choice.equals("N"));

        if (choice.equals("N")) {
            System.out.println(" Returning to main menu...");
            return;
        } else {
            System.out.println(" See you soon!");
            System.exit(0); //  Terminate the app
        }
    }

    private void handleCreate() throws SQLException {
    	String choice;
        do {
            choice = InputUtil.getString("Are you sure you want to create a new account? (Y/N): ").trim().toUpperCase();
            if (!choice.equals("Y") && !choice.equals("N")) {
                System.out.println("❌ Invalid input. Please enter Y or N only.");
            }
        } while (!choice.equals("Y") && !choice.equals("N"));

        if (choice.equals("N")) {
            System.out.println(" Returning to main menu...");
            return;
        }
    	System.out.println("\n Create New Account");

    	String name = InputUtil.getNonEmptyString("Enter your name: ");        
    	String mobile = InputUtil.getValidMobile("Enter 10-digit mobile number: ");
        String email = InputUtil.getValidEmail("Enter email address: ");
        String password = InputUtil.getValidPassword("Set a password (min 4 chars): ");
        double deposit = InputUtil.getValidDouble("Enter initial deposit (min ₹100): ");

        int accId = service.createAccount(name, deposit, password, mobile, email);
        System.out.println(" Account created successfully. Your Account ID: " + accId);
    }
//    private void handleAccountCreation() throws SQLException {
//        String choice;
//        do {
//            choice = InputUtil.getString("Are you sure you want to create a new account? (Y/N): ").trim().toUpperCase();
//            if (!choice.equals("Y") && !choice.equals("N")) {
//                System.out.println("❌ Invalid input. Please enter Y or N only.");
//            }
//        } while (!choice.equals("Y") && !choice.equals("N"));
//
//        if (choice.equals("Y")) {
//        	handleCreate(); // ✅ Call your account creation logic here
//        } else {
//            System.out.println("🔙 Returning to main menu...");
//        }
//    }
    private void handleLogin() throws SQLException {
        String choice;
        do {
            choice = InputUtil.getString("Are you sure you want to login? (Y/N): ").trim().toUpperCase();
            if (!choice.equals("Y") && !choice.equals("N")) {
                System.out.println("❌ Invalid input. Please enter Y or N only.");
            }
        } while (!choice.equals("Y") && !choice.equals("N"));

        if (choice.equals("N")) {
            System.out.println(" Returning to main menu...");
            return;
        }
        
        int id = InputUtil.getValidInt("Enter Account ID: ");
        int pin = InputUtil.getValidPin("Enter 4-digit PIN: ");

        try {
            Account loggedIn = service.login(id, pin);  // now properly uses the returned Account
            System.out.println(" Login successful.");
            System.out.println("Welcome, " + loggedIn.getName());
            runBankOperations(id);  
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());  
        }
    }
    private void runBankOperations(int loggedInId) throws SQLException {
        while (true) {
            MenuService.showUserMenu();
            int choice = InputUtil.getValidInt("Enter your choice: ");

            switch (choice) {
                case 1 -> System.out.println(" Balance: ₹" + service.checkBalance(loggedInId));
                case 2 -> {
                    double amt = InputUtil.getValidDouble("Enter deposit amount: ");
                    service.deposit(loggedInId, amt);
                }
                case 3 -> {
                    double amt = InputUtil.getValidDouble("Enter withdrawal amount: ");
                    service.withdraw(loggedInId, amt);
                }
                case 4 -> {
                    int to = InputUtil.getValidInt("Enter receiver ID: ");
                    if (to == loggedInId) {
                        System.out.println(" Cannot transfer to self.");
                        break;
                    }
                    double amt = InputUtil.getValidDouble("Enter amount: ");
                    service.transfer(loggedInId, to, amt);
                }
                case 5 -> service.printTransactionHistory(loggedInId);
                case 6 -> service.printMiniStatement(loggedInId);
                case 7 -> {
                    while (true) {
                        System.out.println("\n---- Edit Account Details ----");
                        System.out.println("1. Edit Name");
                        System.out.println("2. Edit Mobile");
                        System.out.println("3. Edit Email");
                        System.out.println("4. Back");

                        int editChoice = InputUtil.getValidInt("Choose option: ");

                        try {
                            switch (editChoice) {
                                case 1 -> {
                                    String newName = InputUtil.getNonEmptyString("Enter new name: ");
                                    Account acc = service.getAccount(loggedInId); // fetch current
                                    service.updateAccountDetails(loggedInId, newName, acc.getMobile(), acc.getEmail());
                                }
                                case 2 -> {
                                    String newMobile = InputUtil.getValidMobile("Enter new mobile: ");
                                    Account acc = service.getAccount(loggedInId);
                                    service.updateAccountDetails(loggedInId, acc.getName(), newMobile, acc.getEmail());
                                }
                                case 3 -> {
                                    String newEmail = InputUtil.getValidEmail("Enter new email: ");
                                    Account acc = service.getAccount(loggedInId);
                                    service.updateAccountDetails(loggedInId, acc.getName(), acc.getMobile(), newEmail);
                                }
                                case 4 -> {
                                    System.out.println(" Back to main menu.");
                                    break;
                                }
                                default -> System.out.println("❌ Invalid option.");
                            }
                        } catch (Exception e) {
                            System.out.println("❌ " + e.getMessage());
                        }

                        if (editChoice == 4) break;
                    }
                }
                case 8 -> {
                    int accId = InputUtil.getValidInt("Enter your Account ID: ");
                    String pwd = InputUtil.getString("Enter your Password: ");
                    try {
                        service.deleteAccount(accId, pwd);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                
                case 9 -> {
                    System.out.println(" Logged out.");
                    return;
                }
                default -> System.out.println(" Invalid choice.");
            }
        }
    }

    private void handleCheckBalance() throws SQLException {
        int id = InputUtil.getValidInt("Enter account ID: ");
        System.out.println(" Balance: ₹" + service.checkBalance(id));
    }

    private void handleDeposit() throws SQLException {
        int id = InputUtil.getValidInt("Enter account ID: ");
        System.out.println("Enter deposit amount or type 0 to cancel:");
        double amount = InputUtil.getValidDouble("Amount: ");
        if (amount == 0) {
            System.out.println(" Deposit cancelled. Returning to main menu.");
            return;
        }
        service.deposit(id, amount);
        System.out.println(" Deposit successful!");
    }

    private void handleWithdraw() throws SQLException {
        int id = InputUtil.getValidInt("Enter account ID: ");
        System.out.println("Enter withdrawal amount or type 0 to cancel:");
        double amount = InputUtil.getValidDouble("Amount: ");
        if (amount == 0) {
            System.out.println(" Withdrawal cancelled.");
            return;
        }
        service.withdraw(id, amount);
        System.out.println(" Withdrawal successful!");;
    }

    private void handleTransfer(Account sender) throws SQLException {
        System.out.println("Enter recipient account ID or 0 to cancel:");
        int to = InputUtil.getValidInt("To Account ID: ");
        if (to == 0) {
            System.out.println(" Transfer cancelled.");
            return;
        }

        if (sender.getId() == to) {
            System.out.println(" Cannot transfer to your own account.");
            return;
        }

        System.out.println("Enter amount to transfer or 0 to cancel:");
        double amt = InputUtil.getValidDouble("Amount: ");
        if (amt == 0) {
            System.out.println(" Transfer cancelled.");
            return;
        }

        service.transfer(sender.getId(), to, amt);
        System.out.println(" Transfer of ₹" + amt + " successful to Account ID: " + to);
    }
}
