package com.company.model;

import com.company.model.account.BankAccount;

public class CommissionWorker implements IWorker {
    private IWorker nextWorker;

    @Override
    public void processRequest(Request request, BankAccount bankAccount) {
        System.out.println("Commission worker is working");
        if (request.isTakeCommission()) {
            bankAccount.subCommission();
        }
        if (nextWorker != null)
            nextWorker.processRequest(request, bankAccount);
    }

    @Override
    public IWorker setNextWorker(IWorker worker) {
        return nextWorker = worker;
    }
}
