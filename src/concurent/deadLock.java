package concurent;

/**
 * @author : gaoxizhuo
 * @version V1.0
 * @Description:
 * @date : 2025年06月30日 10:34
 */
public class deadLock {

    static Object lock1 = new Object();
    static Object lock2 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized(lock1){
                System.out.println("t1 get lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized(lock2){
                    System.out.println("1");
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized(lock2){
                System.out.println("t2 get lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized(lock1){
                    System.out.println("2");
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();//主线程阻塞等待t1结束
        t2.join();//主线程阻塞等待t2结束
        System.out.println("over");
    }
}
