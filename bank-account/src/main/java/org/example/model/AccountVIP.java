package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AccountVIP extends Account {
    protected double individualInterest;
    protected double accountOverdraftLimit;

    public AccountVIP(Person person, double amount, double individualInterest, double accountOverdraftLimit) {
        super(person, amount);
        this.individualInterest = individualInterest;
        this.accountOverdraftLimit = accountOverdraftLimit;
    }

    @Override
    public boolean payoff(double value) {
        if (value < 0 || amount - value < accountOverdraftLimit) {
            System.out.println("Przekroczony limit debetu lub ujemna kwota");
            return false;
        }
        amount -= value;
        return true;
    }

    @Override
    public void actualization() {
        amount = amount * individualInterest;
    }
}
