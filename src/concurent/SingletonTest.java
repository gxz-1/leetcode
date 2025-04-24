package concurent;

class BrokenSingleton {
    private static BrokenSingleton instance; // 没加 volatile！

    public String value; // 用来观察对象是否完整初始化

    private BrokenSingleton() {
        // 模拟初始化过程
        try {
            Thread.sleep(50); // 模拟复杂初始化过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "I'm fully initialized";
    }

    public static BrokenSingleton getInstance() {
        if (instance == null) {
            synchronized (BrokenSingleton.class) {
                if (instance == null) {
                    instance = new BrokenSingleton();
                }
            }
        }
        return instance;
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        // 启动100个线程试图获取单例实例
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                BrokenSingleton singleton = BrokenSingleton.getInstance();
                if (singleton.value == null) {
                    // 打印出"半初始化对象"
                    System.out.println("警告：获取到了半初始化对象！");
                }
            }).start();
        }
    }
}

