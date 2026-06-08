package org.example;

public class Node {
    private final Integer v;
    private Node next;

    public Node(int v) {
        this.v = v;
    }

    public Integer getV() {
        return v;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return v + " " + next;
    }
}
