package org.example.model;

import org.example.exception.CallHistoryIsFullException;
import org.example.exception.InvalidPhoneNumberException;

import java.awt.*;

public class CellPhone extends Phone {
    protected String[] callHistory = new String[10];
    protected int callsInHistoryCounter = 0;

    public CellPhone(String communicationInterface, Color color) {
        super(communicationInterface, color);
    }

    public void call(String number) throws InvalidPhoneNumberException {
        isPhoneNumber(number);
        if (callsInHistoryCounter >= 10) {
            throw new CallHistoryIsFullException("Spis połączeń jest pełny");
        }
        callHistory[callsInHistoryCounter] = number;
        callsInHistoryCounter++;
        System.out.println("Dzwonisz na numer: " + number);
    }

    public void showCallHistory(){
        for (int i = 0; i < callsInHistoryCounter; i++) {
            System.out.println(callHistory[i]);
        }
    }
}
