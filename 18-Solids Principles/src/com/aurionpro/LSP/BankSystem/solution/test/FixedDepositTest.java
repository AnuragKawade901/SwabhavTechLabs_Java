package com.aurionpro.LSP.BankSystem.solution.test;

import com.aurionpro.LSP.BankSystem.solution.model.FixedDepositAccount;
import com.aurionpro.LSP.BankSystem.solution.model.IDeposit;
import com.aurionpro.LSP.BankSystem.solution.model.IWithdraw;
import com.aurionpro.LSP.BankSystem.solution.model.SavingAccount;

public class FixedDepositTest {
public static void main(String[] args) {
	IDeposit d1 = new SavingAccount();
	IDeposit d2 =  new FixedDepositAccount();
	
	d1.deposit(100000);
	d2.deposit(200000);
	
	if (d1 instanceof IWithdraw) {
        ((IWithdraw) d1).withdraw(500);
    }
	
	  if (d2 instanceof IWithdraw) {
          ((IWithdraw) d2).withdraw(1000); // Won't execute
	  }
//       else {
//          System.out.println("Withdraw not supported on FixedDepositAccount.");
//      }

}
}
