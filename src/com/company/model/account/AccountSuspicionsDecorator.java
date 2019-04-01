package com.company.model.account;

public class AccountSuspicionsDecorator implements BankAccount {
    private BankAccount baseBankAccount;
    private final static double LIMIT = 1000;

    AccountSuspicionsDecorator(BankAccount bankAccount) {
        this.baseBankAccount = bankAccount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < LIMIT)
            baseBankAccount.withdraw(amount);
        else
            System.out.println("Withdrawing canceled. Suspicious client");
    }

    @Override
    public void send(double amount, BankAccount bankAccount) {
        if (amount < LIMIT)
            baseBankAccount.send(amount, bankAccount);
        else
            System.out.println("Sending canceled. Suspicious client");
    }

    @Override
    public void payIn(double amount) {
        baseBankAccount.payIn(amount);
    }

    @Override
    public void addPercents() {
        baseBankAccount.addPercents();
    }

    @Override
    public void subCommission() {
        baseBankAccount.subCommission();
    }
}
