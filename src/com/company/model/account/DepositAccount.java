package com.company.model.account;

import java.util.Date;

public class DepositAccount implements BankAccount {
    private double money;
    private Date depositUnlock;

    DepositAccount(Date depositUnlock) {
        this.depositUnlock = depositUnlock;
    }

    @Override
    public void withdraw(double amount) {
        if (new Date().after(depositUnlock) && (money - amount) >= 0) {
            System.out.println("Withdrawing money from deposit account");
            money -= amount;
        } else
            System.out.println("Withdrawing canceled. Deposit is locked");
    }

    @Override
    public void payIn(double amount) {
        System.out.println("Paying in. Deposit account");
        money += amount;
    }

    @Override
    public void addPercents() {
        System.out.println("Percents added");
        if (money < 1000) {
            money += money * 0.08;
        } else {
            money += money * 0.1;
        }
    }
}
