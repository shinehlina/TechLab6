package com.company.model;

import com.company.model.account.BankAccount;

public class PercentWorker implements IWorker{
    private IWorker nextWorker;

    @Override
    public void processRequest(Request request, BankAccount bankAccount) {
        System.out.println("Percent worker is working");
        if (request.isTakeMoney()) {
            bankAccount.addPercents();
        }
        if (nextWorker != null)
            nextWorker.processRequest(request, bankAccount);
    }

    @Override
    public IWorker setNextWorker(IWorker worker) {
        return nextWorker = worker;
    }
}
