package com.yzh.multithread;

public class YieldLockTest {

    private static Object obj = new Object();

    /**
     * 同步锁synchronized & yield
     * 说明：主线程main中启动两个线程a和b，a和b在run()会引用同一个对象的同步锁，即synchronized(obj)，
     *       在a运行过程中，虽然会调用Thread.yield()，但是b是不会获取cpu执行权的，因为a并没有释放同步锁。
     * 效果：a线程执行完才执行b线程
     * */
    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            // 获取obj对象的同步锁
            synchronized (obj) {
                for (int i = 1; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    // i整除4时，调用yield
                    if (i % 4 == 0)
                        Thread.yield();
                }
            }
        }
    }

    /**
     * 同步锁synchronized
     * 说明：主线程main中启动两个线程a和b，a和b在run()会引用同一个对象的同步锁，即synchronized(obj)，
     *       在a运行过程中，b是获取不到cpu执行权的，因为a并没有释放同步锁。
     *  效果：a线程执行完才执行b线程
     */
    static class ThreadD extends Thread {

        public ThreadD(String name) {
            super(name);
        }

        public void run() {
            // 获取obj对象的同步锁
            synchronized (obj) {
                for (int i = 1; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                }
            }
        }
    }

    /**
     * yield
     * 说明：将当前线程由"运行状态"进入"就绪状态"，但不会释放同步锁。
     *       yield()的作用是让步，从而让其它具有相同优先级的就绪线程获取执行权；
     *       但是并不能保证在当前线程调用yield()之后，其它具有相同优先级的线程就一定能获到执行权，也有可能当前线程又进入到"运行状态"继续运行。
     * 效果：a线程执行5次，然后让b线程执行5次，有序交替执行。
     **/
    static class ThreadB extends Thread {

        public ThreadB(String name) {
            super(name);
        }

        public void run() {
            for (int i = 1; i < 10; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                // i为5时，调用yield()
                if (i ==5)
                    Thread.yield();
            }
        }
    }

    /**
     *  执行结果未知
     *  效果：无序交替执行（每次执行结果不一样）
     */
    static class ThreadC extends Thread {

        public ThreadC(String name) {
            super(name);
        }

        public void run() {
            for (int i = 1; i < 10; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
            }
        }
    }

    public static void  main(String[] args){
        ThreadB a=new ThreadB("a");
        ThreadB b=new ThreadB("abcd");
        a.start();
        b.start();
    }
}
