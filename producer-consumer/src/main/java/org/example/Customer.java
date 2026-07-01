package org.example;

import java.util.concurrent.CountDownLatch;

public class Customer implements Runnable {
    private final SharedQueue shared;
    private final CountDownLatch consumed;

    public Customer(SharedQueue shared, CountDownLatch consumed) {
        this.shared = shared;
        this.consumed = consumed;
    }

    @Override
    public void run() {
        while (true) {
            shared.removeElement();
            consumed.countDown();
        }
    }
}