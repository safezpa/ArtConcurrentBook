package chapter02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Count2 {
    private  AtomicInteger ati=new AtomicInteger(0);
    private  int i=0;

    public static void main(String[] args)  {
        Count2 c=new Count2();
        List<Thread> ts=new ArrayList<>();
        long start=System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<100;i++){
                        c.safeCount();
                        c.unsafeCount();
                    }
                }
            });
           // t.start();
        ts.add(t);
        }

        for(Thread t : ts){
            t.start();
        }

        for (Thread t:
             ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        System.out.println(c.ati);
        System.out.println(c.i);
        System.out.println(System.currentTimeMillis()-start);


    }


    /**
     *  CAS
     *  线程安全的增加i
    **/
    private void safeCount(){
        for (;;){
            int i=ati.get();
            boolean succ=ati.compareAndSet(i,++i);
            if (succ)
                break;
        }
    }

    /**
     *
     */
    private void unsafeCount(){
        i++;
    }
}
