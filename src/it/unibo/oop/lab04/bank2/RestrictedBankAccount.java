package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.StrictBankAccount;

public class RestrictedBankAccount extends AbstractBankAccount {
	private static final int MANAGEMENT_FEE = 5;
	
	public RestrictedBankAccount(final double balance, final int usrID) {
		super(balance, usrID);
	}

	protected boolean isWithdrawAllowed(double amount) {
		return this.getBalance() > amount;
	}
	
	protected double computeFee() {
		return RestrictedBankAccount.MANAGEMENT_FEE;
	}

}
