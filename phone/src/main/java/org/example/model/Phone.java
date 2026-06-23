package org.example.model;

import org.example.exception.InvalidPhoneNumberException;

import java.awt.*;

public class Phone {
    protected final String communicationInterface;
    protected final Color color;

    public Phone(String communicationInterface, Color color) {
        this.communicationInterface = communicationInterface;
        this.color = color;
    }

    public void call(String number) throws InvalidPhoneNumberException {
        isPhoneNumber(number);
        System.out.println("Dzwonisz na numer: " + number);
    }

    public static void isPhoneNumber(String number) throws InvalidPhoneNumberException {
        if(!number.matches("\\d{3}-\\d{3}-\\d{3}")){
            throw new InvalidPhoneNumberException("Błędny numer telefonu");
        }
    }

    public void showCallHistory(){
        System.out.println("Brak historii połączeń");
    }
}
