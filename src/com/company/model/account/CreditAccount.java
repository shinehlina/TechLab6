package com.company.model.account;

public class CreditAccount implements BankAccount {
    private float fixedCommission;
    private double money;

    CreditAccount(float fixedCommission) {
        this.fixedCommission = fixedCommission;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawing money from credit account");
        money -= amount;
    }

    @Override
    public void payIn(double amount) {
        System.out.println("Paying in. Credit account");
        money += amount;
    }

    @Override
    public void subCommission() {
        System.out.println("Commission taken");
        if (money < 0) {
            money -= money * fixedCommission / 100;
        }
    }
}
