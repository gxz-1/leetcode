package concurent;

//题目：创建三个线程 按顺序打印1-100 线程1打印1 2打印2 3打印3
public class SequentialPrint {

    private static final Object lock = new Object();
    private static int number = 1;

    public static void main(String[] args) {
        Runnable printTask = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (number <= 100) {
                        String threadName = Thread.currentThread().getName();

                        // 判断当前线程是否该打印
                        if ((number % 3 == 1 && threadName.equals("Thread-1")) ||
                            (number % 3 == 2 && threadName.equals("Thread-2")) ||
                            (number % 3 == 0 && threadName.equals("Thread-3"))) {
                            System.out.println(threadName + " -> " + number);
                            number++;
                            lock.notifyAll(); // 通知其他线程
                        } else {
                            try {
                                lock.wait(); // 不是该线程打印则等待
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        };

        // 创建3个线程
        Thread t1 = new Thread(printTask, "Thread-1");
        Thread t2 = new Thread(printTask, "Thread-2");
        Thread t3 = new Thread(printTask, "Thread-3");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
