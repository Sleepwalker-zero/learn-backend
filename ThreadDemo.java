package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         *第一种
         * 定义一个类继承Thread
         * 重写run
         * 创建子类对象，启动线程
         *
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("线程1");
        t2.setName("线程2");
        //调用start启动线程
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        /**
         * 第二种
         * 定义一个类实现runnable接口
         * 重写run方法
         * 创建自己类对象
         * 创建thread类对象
         */
        //创建MyRun
        MyRun mr = new MyRun();

        //创建线程对象
        Thread t3 = new Thread(mr);
        Thread t4 = new Thread(mr);

        t3.setDaemon(true);//守护线程，当其他线程结束时守护线程也会陆续结束
        t3.setName("线程3");
        t4.setName("线程4");
        //开启线程

        t3.start();
        t4.start();
        /**
         *
         * 第三种
         * 特点：可以获取线程执行结果
         *
         * 创建callable对象
         * 创建futuretask对象 管理多线程结果
         * 创建thread对象
         */
        MyCall mc = new MyCall();
        FutureTask<Integer> ft = new FutureTask<>(mc);

        Thread t5 = new Thread(ft);
        t5.start();
        //获取线程结果
        Integer result = ft.get();
        System.out.println(result);
    }
}
