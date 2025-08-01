package com.aurionpro.BankMP.test;

import com.aurionpro.BankMP.model.SBJBankFacade;

public class SBJBankApp {
    public static void main(String[] args) {
        SBJBankFacade bank = new SBJBankFacade();
        bank.start();
    }
}
