package org.example;

import org.example.model.Account;
import org.example.model.AccountVIP;
import org.example.model.BankAccount;
import org.example.model.Person;

public class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount(new Person("Jan", "Kowalski", 44), 10000);
        accounts[1] = new Account(new Person("Arek", "Wilk", 21), 3000);
        accounts[2] = new AccountVIP(new Person("Adam", "Giemlik", 66), 7000000, 1.05, -100000);

        accounts[0].payment(500);
        accounts[1].payoff(1000);
        accounts[2].transfer(accounts[0], 2000);

        Account.setInterest(1.03);

        for (BankAccount account : accounts) {
            account.actualization();
            System.out.println(account);
        }
    }
}
