package org.example;

public class Stack {
    private Node head;
    private int size;

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(Integer v) {
        Node n = new Node(v);
        n.setNext(head);
        head = n;
        size++;
    }

    public Integer pop() {
        if (head == null) {
            System.out.println("Stack jest pusty");
            return null;
        }
        Integer value = head.getV();
        head = head.getNext();
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public void remove(Integer v) {
        Node curent = head;
        if(curent==null){
            System.out.println("pusty stack");
            return;
        }
        if(curent.getV().equals(v)){
             head = head.getNext();
             size--;
             return;
        }
        while (curent.getNext()!=null){
                if(curent.getNext().getV().equals(v)){
                    size--;
                    curent.setNext(curent.getNext().getNext());
                    return;
                }
                curent=curent.getNext();
        }
    }
}
