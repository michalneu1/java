package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SharedStack queue = new SharedStack();
        Thread producer = new Thread(new Producer(queue));
        Thread customer1 = new Thread(new Customer(queue));
        Thread customer2 = new Thread(new Customer(queue));
        Thread customer3 = new Thread(new Customer(queue));
        producer.start();
        customer1.setDaemon(true);
        customer2.setDaemon(true);
        customer3.setDaemon(true);
        customer1.start();
        customer2.start();
        customer3.start();

    }
}