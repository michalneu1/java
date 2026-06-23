package org.example.model;
import java.awt.*;
import java.util.Arrays;
import java.util.Optional;

public class Smartphone extends CellPhone {
    protected Person[] friends;

    public Smartphone(String communicationInterface, Color color, Person[] friends) {
        super(communicationInterface, color);
        this.friends = friends;
    }

    public void showCallHistory() {
        Arrays.stream(callHistory)
                .forEach(number -> getFriendByNumber(number)
                        .ifPresentOrElse(this::showPerson,
                                () -> System.out.println(number)));
    }

    public Optional<Person> getFriendByNumber(String number) {
        return Arrays.stream(friends)
                .filter(person -> person.number().equals(number))
                .findFirst();
    }

    public void showPerson(Person person){
          System.out.printf("%s %s %s%n", person.name(),person.lastName(),person.number());
    }
}
