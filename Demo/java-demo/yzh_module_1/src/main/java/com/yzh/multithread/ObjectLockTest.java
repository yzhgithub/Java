package com.yzh.multithread;

/**
 *  对象锁的同步和异步
 * */
public class ObjectLockTest {

    public synchronized void method1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        final ObjectLockTest objectLock = new ObjectLockTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.method1();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                objectLock.method1();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
