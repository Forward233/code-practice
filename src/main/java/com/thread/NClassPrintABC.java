package com.thread;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yhl
 * @DateTime: 2019/11/14 11:13
 * @Description:
 */
public class NClassPrintABC {


    public static void main(String[] args) {
        nThreadPrint1();
//        nThreadPrintNTimes();
//        nThreadPrintNTimes2();
//        nThreadPrintNTimes3();
//        nThreadPrintNTimes4();
    }


    /**
     * 1.有A、B、C、D四个线程，A线程输出A, B线程输出B, C线程输出C，D线程输出D，
     *   要求,   同时启动四个线程, 按顺序输出ABCD；
     */
    public static void nThreadPrint1() {
        Thread a = new Thread(() -> {
            System.out.print("A");
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("B");
            }

        });
        Thread c = new Thread(() -> {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("C");
        });

        Thread d = new Thread(() -> {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("D");
        });

        d.start();
        c.start();
        b.start();
        a.start();
    }

    /**
     * Method one
     * 2.有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C
     * 要求, 同时启动三个线程, 按顺序输出ABC, 循环10次；
     */
    public static void nThreadPrintNTimes() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new C());
        executorService.submit(new B());
        executorService.submit(new A());
    }

    private static ReentrantLock lock = new ReentrantLock();
    private static int states = 0;
    private static int runTimes = 10;

    static class A extends Thread {

        @Override
        public void run() {
            // 只有进入到if中才会执行i++,绝了
            for (int i = 0; i < runTimes;) {
                if (states % 3 == 0) {
                    System.out.println("ReentrantLock-------第" + (i + 1) + "次:");
                    System.out.println("A");
                    states++;
                    i++;
                }
            }
        }
    }

    static class B extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < runTimes;) {
                if (states % 3 == 1) {
                    System.out.println("B");
                    states++;
                    i++;
                }
            }
        }
    }

    static class C extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes;) {
                if (states % 3 == 2) {
                    System.out.println("C");
                    states++;
                    i++;
                }
            }
        }
    }


    /**
     * Method two
     * synchronized
     */
    public static void nThreadPrintNTimes2() {
        new Thread(new A2()).start();
        new Thread(new B2()).start();
        new Thread(new C2()).start();
    }


    private static final Object object = new Object();

    static class A2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes;) {
                synchronized (this) {
                    if (states % 3 == 0) {
                        System.out.println("synchronized-------第" + (i + 1) + "次:");
                        System.out.println("A");
                        states++;
                        i++;
                    }
                }
            }
        }
    }

    static class B2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes;) {
                synchronized (object) {
                    if (states % 3 == 1) {
                        System.out.println("B");
                        states++;
                        i++;
                    }
                }
            }
        }
    }

    static class C2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes;) {
                synchronized (object) {
                    if (states % 3 == 2) {
                        System.out.println("C");
                        states++;
                        i++;
                    }
                }
            }
        }
    }

    /**
     * Method Three
     * semaphores 信号量
     */
    public static void nThreadPrintNTimes3() {
        new Thread(new A3()).start();
        new Thread(new B3()).start();
        new Thread(new C3()).start();
    }

    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);


    static class A3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes; i++) {
                try {
                    semaphoreA.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("semaphore-------第" + (i + 1) + "次:");
                System.out.println("A");
                semaphoreB.release();
            }
        }
    }

    static class B3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes; i++) {
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                semaphoreC.release();
            }
        }
    }

    static class C3 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes; i++) {
                try {
                    semaphoreC.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                semaphoreA.release();
            }
        }
    }

    /**
     * Method Four
     * lock + Condition
     * 这种方法多次一举，仅作尝试，lock就可以实现
     */

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private char currentThreadName ='A';

    public static void nThreadPrintNTimes4() {
        NClassPrintABC printABC = new NClassPrintABC();
        new Thread(printABC.new A4()).start();
        new Thread(printABC.new B4()).start();
        new Thread(printABC.new C4()).start();
    }

    class A4 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes; i++) {
                lock.lock();
                while (currentThreadName != 'A') {
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("condition-------第" + (i + 1) + "次:");
                System.out.print("A");
                currentThreadName = 'B';
                conditionB.signal();
                lock.unlock();
            }
        }
    }

    class B4 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < runTimes; i++) {
                lock.lock();
                while (currentThreadName != 'B') {
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                currentThreadName = 'C';
                conditionC.signal();
                lock.unlock();
            }
        }
    }

    class C4 extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < runTimes; j++) {
                lock.lock();
                while (currentThreadName != 'C') {
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                currentThreadName = 'A';
                conditionA.signal();
            }
            lock.unlock();
        }
    }
}
