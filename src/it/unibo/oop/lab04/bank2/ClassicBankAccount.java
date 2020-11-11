package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {	
	
	public ClassicBankAccount(final double balance, final int usrID) {
		super(balance, usrID);
	}

	protected boolean isWithdrawAllowed(double amount) {
		return true;
	}

	protected double computeFee() {
		return 0;
	}

}
