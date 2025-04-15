package concurent;

//多线程交叉打印 打印n个foobar
class FooBar {
    private int n;
    private volatile boolean fooOk;
    
    public FooBar(int n) {
        this.n = n;
        this.fooOk = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(fooOk){
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooOk = true;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(!fooOk){
                    wait();
                }
                printBar.run();
                fooOk=false;
                notify();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        }
    }
}