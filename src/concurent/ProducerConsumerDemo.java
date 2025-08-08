package concurent;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public static void main(String[] args) {
        ProducerConsumerDemo demo = new ProducerConsumerDemo();
        // 启动2个生产者线程和2个消费者线程
        for (int i = 0; i < 2; i++) {
            new Thread(demo.new Producer(), "Producer-" + i).start();
            new Thread(demo.new Consumer(), "Consumer-" + i).start();
        }
    }

    // 生产者
    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == CAPACITY) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 等待，队列满");
                            queue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    int value = (int) (Math.random() * 100);
                    queue.offer(value);
                    System.out.println(Thread.currentThread().getName() + " 生产：" + value + "，队列剩余：" + queue.size());
                    queue.notifyAll(); // 唤醒所有等待线程（生产者、消费者都可能等待）
                }
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }

    // 消费者
    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " 等待，队列空");
                            queue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    int value = queue.poll();
                    System.out.println(Thread.currentThread().getName() + " 消费：" + value + "，队列剩余：" + queue.size());
                    queue.notifyAll(); // 唤醒所有等待线程（生产者、消费者都可能等待）
                }
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        }
    }
}
