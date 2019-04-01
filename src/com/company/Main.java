package com.company;

import com.company.model.*;
import com.company.model.account.AccountFactory;
import com.company.model.account.BankAccount;

public class Main {

    public static void main(String[] args) {
        Client client = new Client.Builder("Alexey", "Pet")
                .setAddress("Spb, Sev 12")
                .build();
        AccountFactory accountFactory = new AccountFactory();
        BankAccount account = accountFactory.createAccount(9, 0, null, client);

        account.withdraw(500);
        account.payIn(2000);
        account.withdraw(1100);

        Request request = new Request(true, true);
        IWorker worker = new PercentWorker();
        worker.setNextWorker(new CommissionWorker());

        worker.processRequest(request, account);
    }
}
