package org.example.model;

import org.example.exception.CallHistoryIsFullException;
import org.example.exception.InvalidPhoneNumberException;

import java.awt.*;

public class CellPhone extends Phone {
    protected static final int CALL_HISTORY_MAX_SIZE = 10;
    protected String[] callHistory = new String[CALL_HISTORY_MAX_SIZE];
    protected int callsInHistoryCounter = 0;

    public CellPhone(String communicationInterface, Color color) {
        super(communicationInterface, color);
    }

    public void call(String number) throws InvalidPhoneNumberException {
        isPhoneNumber(number);
        if (callsInHistoryCounter >= CALL_HISTORY_MAX_SIZE) {
            throw new CallHistoryIsFullException("Spis połączeń jest pełny");
        }
        callHistory[callsInHistoryCounter] = number;
        callsInHistoryCounter++;
        System.out.println("Dzwonisz na numer: " + number);
    }

    public void showCallHistory() {
        for (int i = 0; i < callsInHistoryCounter; i++) {
            System.out.println(callHistory[i]);
        }
    }
}
