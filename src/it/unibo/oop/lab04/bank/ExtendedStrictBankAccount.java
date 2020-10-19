package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount{
	private static final double TRANSACTION_FEE = 0.1;
	
	public ExtendedStrictBankAccount(int usrID, double balance) {
		super(usrID, balance);
	}
	
	public void computeManagementFees(final int usrID) {
        final double feeAmount = SimpleBankAccount.MANAGEMENT_FEE + (this.getNTransactions()* ExtendedStrictBankAccount.TRANSACTION_FEE);
        if (this.checkUser(usrID) && this.isWithdrawAllowed(feeAmount)) {
            this.withdraw(usrID, feeAmount);
        }
    }
	
	private boolean isWithdrawAllowed(final double amount) {
        return this.getBalance() > amount;
    }
	
	public void depositFromATM(final int usrID, final double amount) {
		super.deposit(usrID, amount - ExtendedStrictBankAccount.TRANSACTION_FEE);
    }
	
	public void withdrawFromATM(final int usrID, final double amount) {
        super.withdraw(usrID, amount + ExtendedStrictBankAccount.TRANSACTION_FEE);
    }
}
