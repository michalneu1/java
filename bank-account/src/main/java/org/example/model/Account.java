package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Account extends BankAccount {
    protected static double interest = 1.0;

    public Account(Person person, double amount) {
        super(person, amount);
    }

    public static void setInterest(double interest) {
        Account.interest = interest;
    }

    @Override
    public void actualization() {
        amount = amount * interest;
    }
}
