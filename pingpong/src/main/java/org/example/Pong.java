package org.example;

public class Pong extends Thread{
    int counter=0;
    public void run(){
        while (true){
            counter++;
            System.out.println(" pong "+ counter );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
