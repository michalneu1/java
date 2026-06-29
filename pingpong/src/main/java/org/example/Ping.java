package org.example;

public class Ping implements Runnable{
    public void run(){
        while (true){
            System.out.print("ping");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
