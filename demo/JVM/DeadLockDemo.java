package org.example;

public class DeadLockDemo {

        // 创建两个资源对象
        private static final Object resource1 = new Object();
        private static final Object resource2 = new Object();

        public static void main(String[] args) {
            // 线程1：先获取resource1，再尝试获取resource2
            Thread thread1 = new Thread(() -> {
                synchronized (resource1) {
                    System.out.println("线程1获取了资源1");

                    try {
                        // 休眠一小段时间，确保线程2有机会获取资源2
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程1等待获取资源2");
                    synchronized (resource2) {
                        System.out.println("线程1获取了资源2");
                    }
                }
            });

            // 线程2：先获取resource2，再尝试获取resource1
            Thread thread2 = new Thread(() -> {
                synchronized (resource2) {
                    System.out.println("线程2获取了资源2");

                    try {
                        // 休眠一小段时间，确保线程1有机会获取资源1
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程2等待获取资源1");
                    synchronized (resource1) {
                        System.out.println("线程2获取了资源1");
                    }
                }
            });

            // 启动两个线程
            thread1.start();
            thread2.start();
        }
    }


