package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {
    protected final Person person;
    protected double amount;

    public boolean payment(double value) {
        if (value < 0) {
            System.out.println("Nie można wpłacić ujemnej kwoty");
            return false;
        }
        amount += value;
        return true;
    }

    public boolean payoff(double value) {
        if (value < 0 || amount - value < 0) {
            System.out.println("Brak środków lub ujemna kwota");
            return false;
        }
        amount -= value;
        return true;
    }

    public boolean transfer(BankAccount account, double amount) {
        if (payoff(amount)) {
            return account.payment(amount);
        }
        return false;
    }

    public void actualization() {
        System.out.println("Rachunek podstawowy");
    }
}
