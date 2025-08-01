package com.aurionpro.BankMP.model;

public class SBJBankFacade {
    private CustomerService customerService = new CustomerService();
    private AccountService accountService = new AccountService();
    private TransactionService transactionService = new TransactionService();

    public void start() {
        customerService.startMenu(accountService, transactionService);
    }
}
