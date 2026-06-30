package org.example;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedStack {
    Stack<String> stack = new Stack<>();
    final int limit = 5;
    Lock lock = new ReentrantLock();
    Condition isNotFull = lock.newCondition();
    Condition isNotEmpty = lock.newCondition();

    public void addElement() {
        lock.lock();
        try {
            while (stack.size() >= limit) {
                System.out.printf("[ %s ] Kolejka pelna, czekam...%n",Thread.currentThread().getName());
                isNotFull.await();
            }
            stack.add("element");
            System.out.printf("[ %s ] Dodano element. Rozmiar:  %s%n",Thread.currentThread().getName(),stack.size());
            isNotEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void removeElement() {
        lock.lock();
        try {
            while (stack.isEmpty()) {
                System.out.printf("[ %s ] Kolejka pusta, czekam...%n",Thread.currentThread().getName());
                isNotEmpty.await();
            }
            stack.pop();
            System.out.printf("[ %s ] Zabrano element. Rozmiar: %s%n",Thread.currentThread().getName(), stack.size());
            isNotFull.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
