package com.aurionpro.model.student;

public class Accountant extends User {
    public static double totalFeeCollected = 0;
    public static double totalSalaryPaid = 0;

    public Accountant(String username) {
        super(username);
    }

    public void processPayment(Student student, double amount, PaymentMode mode) {
        student.payFee(amount);
        totalFeeCollected += amount;
        System.out.println("Fee paid by " + student.getName() + ": ₹" + amount + " via " + mode);
    }

    public void processPayment(Proffesor professor, PaymentMode mode) {
        double salary = professor.getSalary();
        totalSalaryPaid += salary;
        System.out.println("Salary paid to " + professor.getName() + ": ₹" + salary + " via " + mode);
    }
}
