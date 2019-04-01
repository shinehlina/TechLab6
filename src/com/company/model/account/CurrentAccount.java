package com.company.model.account;

public class CurrentAccount implements BankAccount {
    private float fixedPercent;
    private double money;

    CurrentAccount(float fixedPercent) {
        this.fixedPercent = fixedPercent;
    }

    @Override
    public void withdraw(double amount) {
        if ((money - amount) >= 0) {
            System.out.println("Withdrawing money from current account");
            money -= amount;
        } else {
            System.out.println("Withdrawing canceled. Not enough money on current account");
        }
    }

    @Override
    public void payIn(double amount) {
        System.out.println("Paying in. Current account");
        money += amount;
    }

    @Override
    public void addPercents() {
        System.out.println("Percents. Current account");
        money += money * fixedPercent / 100;
    }
}
