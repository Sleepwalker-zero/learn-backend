package org.example;

public class MyThread extends Thread {

    @Override
    public void run() {
        //书写线程code
        for (int i = 0; i < 100; i++) {
            System.out.println("hello thread " + getName());
        }
    }
}
