package com.company.model;

import com.company.model.account.BankAccount;

public interface IWorker {
    void processRequest(Request request, BankAccount bankAccount);

    IWorker setNextWorker (IWorker worker);
}
