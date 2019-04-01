package com.company.model.account;

public interface BankAccount {
    void withdraw(double amount);

    void payIn(double amount);

    default void send(double amount, BankAccount bankAccount) {
        System.out.println("Sending money...");
        withdraw(amount);
        bankAccount.payIn(amount);
    }

    default void addPercents() { }

    default void subCommission() { }
}
