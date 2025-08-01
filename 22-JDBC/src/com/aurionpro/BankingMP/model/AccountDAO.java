package com.aurionpro.BankingMP.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccountDAO {
    void createAccount(Account acc) throws SQLException;
    Account getAccount(int id) throws SQLException;                      
    Account getAccount(Connection con, int id) throws SQLException;
    void updateBalance(Connection con, int id, double newBalance) throws SQLException;
    void deleteAccount(int accountId) throws SQLException;
    void updateAccountDetails(int id, String newName, String newMobile, String newEmail) throws SQLException;


}