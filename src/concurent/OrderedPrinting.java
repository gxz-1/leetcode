package concurent;

public class OrderedPrinting {
    // 当前要打印的数字
    private static volatile int  number = 1;
    // 同步对象
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (number > 100) {
                        break;
                    }
                    if (number % 3 == 1) {
                        System.out.println("线程1: " + number);
                        number++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (number > 100) {
                        break;
                    }
                    if (number % 3 == 2) {
                        System.out.println("线程2: " + number);
                        number++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "Thread-2");

        Thread t3 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (number > 100) {
                        break;
                    }
                    if (number % 3 == 0) {
                        System.out.println("线程3: " + number);
                        number++;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "Thread-3");

        // 启动三个线程
        t1.start();
        t2.start();
        t3.start();
    }
}