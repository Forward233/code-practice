package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yhl
 * @DateTime: 2020/6/15 5:26
 * @Description:
 * [5种操作带你玩转【交替打印奇偶数】 - 知乎](https://zhuanlan.zhihu.com/p/47948392)
 */
public class ThreadAlternately {


    public static void main(String[] args) {
        method();
    }

    private static ReentrantLock lock = new ReentrantLock();
    private static int count = 0;
    private static int times = 10;

    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();


    private static void method() {
        // 启用线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 先从0，偶数开始
        executorService.execute(() -> {
            while (count <= 100) {
                try {
                    lock.lock();
                    System.out.println("偶: " + count);
                    count++;
                    // 把偶数线程阻塞
                    condition1.await();
                    // 把奇数线程唤醒
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        executorService.execute(() -> {
            while (count <= 100) {
                try {
                    lock.lock();
                    System.out.println("奇: " + count);
                    count++;
                    // 把偶数线程唤醒
                    condition1.signal();
                    // 把奇数线程阻塞
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
    }

    /**
     * 信号量控制并发数
     */
    private static final Semaphore semaphore = new Semaphore(2);
    private static void method2() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() +
                        "进入,当前已有" + (2 - semaphore.availablePermits()) + "个并发");
                semaphore.release();
            });
        }
    }

    private static void method3() {

        new Thread(() ->{
            for (int i = 0; i < times;) {
                if (count % 2 == 0) {
                    System.out.println(count);
                    ++count;
                    i++;
                }
            }
        }).start();

        new Thread(() ->{
            for (int i = 0; i < times; ) {
                if (count % 2 == 1) {
                    System.out.println(count);
                    ++count;
                    i++;
                }
            }
        }).start();
    }
}
