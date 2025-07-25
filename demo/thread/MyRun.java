package org.example;

public class MyRun implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            //静态方法获取线程name
            System.out.println("hello run "+ threadName);
        }
        System.out.println("end" + threadName);

    }
}
