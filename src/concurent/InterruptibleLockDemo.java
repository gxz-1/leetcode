package concurent;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleLockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                lock.lock(); // 普通获取锁，不响应中断
                System.out.println("线程 t1 获取到锁，开始执行任务...");
                // 模拟任务执行较长时间
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("线程 t1 被中断。");
            } finally {
                lock.unlock();
                System.out.println("线程 t1 释放锁。");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                // 使用可中断方式获取锁
                lock.lockInterruptibly();
                System.out.println("线程 t2 获取到锁，开始执行任务...");
            } catch (InterruptedException e) {
                System.out.println("线程 t2 在等待锁时被中断。");
            } finally {
                // 确保只有获取锁后才释放锁
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    System.out.println("线程 t2 释放锁。");
                }
            }
        });

        t1.start();
        // 确保 t1 先获取到锁
        try { Thread.sleep(1000); } catch (InterruptedException e) { }
        t2.start();

        // 等待一段时间后中断 t2，模拟外部取消等待的场景
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        System.out.println("主线程发出中断 t2 的信号。");
        t2.interrupt();
    }
}
