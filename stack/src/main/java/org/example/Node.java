package org.example;

public class Node <T> {
    private final T v;
    private Node<T> next;

    public Node(T v) {
        this.v = v;
    }

    public T getV() {
        return v;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return v + " " + next;
    }
}
