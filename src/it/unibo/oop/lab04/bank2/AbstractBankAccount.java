package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {
	private static final double MANAGEMENT_FEE = 5;
	private static final double ATM_TRANSACTION_FEE = 1;
	private static final double TRANSACTION_FEE = 0.1;
	
    private double balance;
    private int nTransactions;
    private final int usrID;
	
    public AbstractBankAccount(final double balance, final int usrID) {
    	this.balance = balance;
    	this.nTransactions = 0;
    	this.usrID = usrID;
    }
    
	
	public void depositFromATM(int usrID, double amount) {
		this.deposit(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
	}
	
	public void withdrawFromATM(int usrID, double amount) {
		this.withdraw(usrID, amount - AbstractBankAccount.ATM_TRANSACTION_FEE);
	}
	
	protected abstract boolean isWithdrawAllowed(final double amount);	
	protected abstract double computeFee();
	
	public void computeManagementFees(int usrID) {
		if (this.checkUser(usrID)) {
            this.withdraw(usrID, AbstractBankAccount.MANAGEMENT_FEE + this.getNTransactions()*AbstractBankAccount.TRANSACTION_FEE);
            this.resetTransactions();
        }
	}
	
	public boolean checkUser(final int id) {
		return this.usrID == id;
	}
	
	public void deposit(int usrID, double amount) {
		this.transactionOp(usrID, amount);
	}
	
	public void withdraw(int usrID, double amount) {
		if(this.isWithdrawAllowed(amount)) {
			this.transactionOp(usrID, -amount);
		}
		
	}

	public double getBalance() {
		return this.balance;
	}

	public int getNTransactions() {
		return this.nTransactions;
	}
	
	private void resetTransactions() {
		this.nTransactions = 0;
	}
	
	private void incTransactions() {
        this.nTransactions++;
    }
	
	private void transactionOp(final int usrID, final double amount) {
		if (this.checkUser(usrID)) {
            this.balance += amount;
            this.incTransactions();
        }
	}	
	
}
