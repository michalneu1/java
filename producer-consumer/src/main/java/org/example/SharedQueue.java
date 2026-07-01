package org.example;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue {
    Queue<String> queue = new ArrayDeque<>();
    final int limit = 5;
    Lock lock = new ReentrantLock(true);
    Condition isNotFull = lock.newCondition();
    Condition isNotEmpty = lock.newCondition();

    public void addElement() {
        lock.lock();
        try {
            while (queue.size() >= limit) {
                System.out.printf("[ %s ] Kolejka pelna, czekam...%n", Thread.currentThread().getName());
                isNotFull.await();
            }
            queue.add("element");
            System.out.printf("[ %s ] Dodano element. Rozmiar:  %s%n", Thread.currentThread().getName(), queue.size());
            isNotEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void removeElement() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.printf("[ %s ] Kolejka pusta, czekam...%n", Thread.currentThread().getName());
                isNotEmpty.await();
            }
            queue.remove();
            System.out.printf("[ %s ] Zabrano element. Rozmiar: %s%n", Thread.currentThread().getName(), queue.size());
            isNotFull.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
