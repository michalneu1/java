package org.example;

import java.util.Random;

public class Producer implements Runnable {
    private final SharedStack shared;
    Random rnd = new Random();
    final int productionLimit = 29;

    public Producer(SharedStack shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        int count =0;
        while (count<= productionLimit) {
            count++;
            try {
                Thread.sleep(rnd.nextInt(0,5000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("wyprodukowano element nr: " + count);
            this.shared.addElement();
        }
    }
}
