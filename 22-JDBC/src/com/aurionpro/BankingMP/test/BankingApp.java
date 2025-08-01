package com.aurionpro.BankingMP.test;

import com.aurionpro.BankingMP.model.AccountDAO;
import com.aurionpro.BankingMP.model.AccountDAOImpl;
import com.aurionpro.BankingMP.model.BankController;
import com.aurionpro.BankingMP.model.BankService;
import com.aurionpro.BankingMP.model.BankServiceImpl;

public class BankingApp {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAOImpl();
        BankService service = new BankServiceImpl(dao);
        BankController controller = new BankController(service);
        controller.start();  
    }
}