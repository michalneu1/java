package org.example;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ExecutionException {
        SharedQueue queue = new SharedQueue();
        int limit = 30;
        CountDownLatch consumed = new CountDownLatch(limit);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<?> prod = pool.submit(new Producer(queue, limit));
        for (int i = 0; i < 3; i++) {
            pool.submit(new Customer(queue, consumed));
        }
        try {
            consumed.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pool.shutdownNow();
    }
}