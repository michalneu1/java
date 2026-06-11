package org.example;

import java.math.BigDecimal;

public enum TicketType {
    CHILD(0.80),ADULT(1),SENIOR(0.70);

    TicketType(double discount) {
        this.discount = discount;
    }

    private final double discount;

    public double getDiscount() {
        return discount;
    }
}
