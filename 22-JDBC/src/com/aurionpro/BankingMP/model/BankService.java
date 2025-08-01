package com.aurionpro.BankingMP.model;

import java.sql.SQLException;

public interface BankService {
	public int createAccount(String name, double deposit, String password, String mobile, String email)throws SQLException ;
	Account login(int id, int pin) throws SQLException;
    
    double checkBalance(int accountId) throws SQLException;
    void deposit(int accountId, double amount) throws SQLException;
    void withdraw(int accountId, double amount) throws SQLException;
    void transfer(int fromId, int toId, double amount) throws SQLException;
    void printTransactionHistory(int accountId) throws SQLException;
    void deleteAccount(int accountId, String password) throws SQLException;
    void printMiniStatement(int accountId) throws SQLException;
    void updateAccountDetails(int id, String name, String mobile, String email) throws SQLException;
    Account getAccount(int id) throws SQLException;  // Used to get current data
    
}
