package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketWindow extends Thread {
    static int ticket = 0;//static保证共享

    //锁对象
    //static final Object lock = new Object();


    public void run() {
        while (true) {
            if (ticketSale1()) break;
        }
    }

    private boolean ticketSale() {
        //           synchronized (lock){
        //字节码锁
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (TicketWindow.class) {
           //----------------------------
           if (ticket < 100) {
               ticket++;
               System.out.println(getName() + "已出售第" + ticket + "张票！！");
           } else {
               System.out.println("票卖光辣！！");
               return true;
           }
       }
        return false;
    }

    static  Lock lock = new ReentrantLock();
    //lock锁
    private boolean ticketSale1() {

        lock.lock();
        try {
            Thread.sleep(50);
            if (ticket < 100) {
                ticket++;
                System.out.println(getName() + "已出售第" + ticket + "张票！！");
            } else {
                System.out.println("票卖光辣！！");
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }

    }
}

