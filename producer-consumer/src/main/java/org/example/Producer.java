package org.example;

import java.util.Random;

public class Producer implements Runnable {
    private final SharedQueue shared;
    private final Random rnd = new Random();
    private int productionLimit;

    public Producer(SharedQueue shared, int productionLimit) {
        this.shared = shared;
        this.productionLimit = productionLimit;
    }

    public int getProductionLimit() {
        return productionLimit;
    }

    @Override
    public void run() {
        while (productionLimit > 0) {
            productionLimit--;
            try {
                Thread.sleep(rnd.nextInt(0, 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shared.addElement();
        }
    }
}