package com.company.model.account;

import com.company.model.Client;

import java.util.Date;

public class AccountFactory {
    public BankAccount createAccount(float percent, float commission, Date dueDate, Client client) {
        BankAccount account;
        if (commission > 0)
            account = checkClient(new CreditAccount(commission), client);
        else if (dueDate != null && percent > 0)
            account = checkClient(new DepositAccount(dueDate), client);
        else if (commission == 0 && percent > 0)
            account = checkClient(new CurrentAccount(percent), client);
        else
            throw new IllegalArgumentException("Cannot find an account with given arguments");
        client.addAccount(account);
        return account;
    }

    private BankAccount checkClient(BankAccount bankAccount, Client client) {
        return client.isSuspicious() ? new AccountSuspicionsDecorator(bankAccount) : bankAccount;
    }
}
