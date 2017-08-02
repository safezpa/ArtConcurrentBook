package myThreadTest;

public class DeadLock {
    private static Object A=new Object();
    private static Object B=new Object();

    public static void main(String[] args) throws InterruptedException {
        new DeadLock().deadlock();
        System.out.println(Thread.currentThread().getName());
        //在main线程中等待main线程死亡才能继续
        //Thread.currentThread().join();
        System.out.println("in main");
    }
    private void deadlock() throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized(A){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("in lock B");
                    }
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("in lock A");
                    }



                }
            }
        });

        //t2.start();
        //t2.join();
        t2.wait();
        t1.start();
        //t1.join();
        System.out.println("in deadlock");

    }
}
