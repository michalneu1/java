package org.example;

public class Stack <T> {
    private Node<T> head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(T v) {
        Node<T> n = new Node<>(v);
        n.setNext(head);
        head = n;
        size++;
    }

    public T pop() {
        if (head == null) {
            System.out.println("Stack jest pusty");
            return null;
        }
        T value = head.getV();
        head = head.getNext();
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public void remove(T v) {
        Node<T> curent = head;
        if (curent == null) {
            System.out.println("pusty stack");
            return;
        }
        if (curent.getV().equals(v)) {
            head = head.getNext();
            size--;
            return;
        }
        while (curent.getNext() != null) {
            if (curent.getNext().getV().equals(v)) {
                size--;
                curent.setNext(curent.getNext().getNext());
                return;
            }
            curent = curent.getNext();
        }
    }
}
