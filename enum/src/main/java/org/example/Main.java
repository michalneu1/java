package org.example;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        TicketType child = TicketType.ADULT;
        System.out.println(Main.getPrice(child));
    }

    private static BigDecimal getPrice(TicketType type) {
        BigDecimal price = new BigDecimal(100);
        return switch (type) {
            case ADULT -> price.multiply(BigDecimal.valueOf(TicketType.ADULT.getDiscount()));
            case CHILD -> price.multiply(BigDecimal.valueOf(TicketType.CHILD.getDiscount()));
            case SENIOR -> price.multiply(BigDecimal.valueOf(TicketType.SENIOR.getDiscount()));
        };
    }
}