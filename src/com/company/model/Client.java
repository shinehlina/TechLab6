package com.company.model;

import com.company.model.account.BankAccount;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Client {
    private String firstName;
    private String lastName;
    private String address;
    private String passport;

    private List<BankAccount> accounts = new ArrayList<>();

    private Client(Builder builder){
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        passport = builder.passport;
    }

    public Client addAccount(BankAccount account) {
        accounts.add(account);
        return this;
    }

    public boolean isSuspicious() {
        return address == null || passport == null;
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        @Setter
        @Accessors(chain = true)
        private String address = null;

        @Setter
        @Accessors(chain = true)
        private String passport = null;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Client build(){
            return new Client(this);
        }
    }
}
