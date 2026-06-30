package org.example;

public class Customer implements Runnable{
    private final SharedStack shared;

    public Customer(SharedStack shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        while (true){
            this.shared.removeElement();
        }
    }
}
