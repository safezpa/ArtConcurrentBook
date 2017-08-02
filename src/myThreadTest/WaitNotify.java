package myThreadTest;

public class WaitNotify {
    static boolean flag=true;
    static Object lock=new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread wait=new Thread(new Wait(),"wait");
        Thread.sleep(5000);

        wait.start();

        Thread notify=new Thread(new Notify(),"notify");

        notify.start();
    }

    private static class Wait  implements Runnable {
        @Override
        public void run() {
            synchronized (lock){
            while (flag){
                System.out.println("wait at "+System.currentTimeMillis());
                try {
                    //wait线程释放锁
                    lock.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("after wait at "+System.currentTimeMillis());
                System.out.println(flag);
            }
                System.out.println("after while");
            }
            System.out.println("end wait run");
        }
    }

    private static class Notify  implements Runnable {
        @Override
        public void run() {
            synchronized (lock){

                System.out.println("notify at "+System.currentTimeMillis());
                //通知等在lock上的线程我执行完成了，你就可以继续了
                lock.notify();
                System.out.println("after notify at "+System.currentTimeMillis());
                flag=false;
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock){

                System.out.println("notify again at "+System.currentTimeMillis());
                //通知等在lock上的线程我执行完成了，你就可以继续了

                lock.notify();

                flag=false;
            }
            System.out.println("after notify again at "+System.currentTimeMillis());

            System.out.println("end notify run");
        }
    }
}
