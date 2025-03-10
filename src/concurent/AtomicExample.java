package concurent;

import java.util.concurrent.atomic.*;

public class AtomicExample {
    public static void main(String[] args) {
        // AtomicInteger 示例
        AtomicInteger atomicInt = new AtomicInteger(10);
        atomicInt.incrementAndGet();//自增
        atomicInt.addAndGet(10);
        System.out.println("AtomicInteger value: " + atomicInt.get());

        // AtomicLong 示例
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.set(20);
        atomicLong.incrementAndGet();
        atomicLong.addAndGet(100L);
        System.out.println("AtomicLong value: " + atomicLong.get());

        //LongAdder示例
        //在高并发的计数场景下，LongAdder 能有效降低线程间的竞争
        LongAdder longAdder = new LongAdder();
        // 模拟多次累加操作
        for (int i = 0; i < 10; i++) {
            longAdder.increment();
        }
        System.out.println("LongAdder value: " + longAdder.sum());

        //AtomicReference示例
        //用于对引用类型变量进行原子操作
        AtomicReference<String> atomicRef = new AtomicReference<>("initial");
        // 尝试将 "initial" 更新为 "updated"
        boolean success = atomicRef.compareAndSet("initial", "updated");
        System.out.println("Update successful: " + success);
        System.out.println("AtomicReference value: " + atomicRef.get());

        //AtomicStampedReference示例
        //类似于 AtomicReference，但在内部增加了一个“标记”或“版本号”，用于解决 ABA 问题。
        AtomicStampedReference<String> stampedRef = new AtomicStampedReference<>("initial", 0);// 初始值 "initial"，初始版本号 0
        int initialStamp = stampedRef.getStamp();
        System.out.println("Before update: value=" + stampedRef.getReference() + ", stamp=" + initialStamp);

        // 尝试将 "initial" 更新为 "updated"，并将版本号加1
        boolean updated = stampedRef.compareAndSet("initial", "updated", initialStamp, initialStamp + 1);
        System.out.println("Update successful: " + updated);
        System.out.println("After update: value=" + stampedRef.getReference() + ", stamp=" + stampedRef.getStamp());
    }
}
