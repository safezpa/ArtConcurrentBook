package chapter08;import java.util.concurrent.CountDownLatch;/** *  * @author tengfei.fangtf * @version $Id: CountDownLatchTest.java, v 0.1 2015-8-1 ����12:08:52 tengfei.fangtf Exp $ */public class CountDownLatchTest2 {    static CountDownLatch c = new CountDownLatch(2);    public static void main(String[] args) throws InterruptedException {        Thread t=new Thread(new Runnable() {            @Override            public void run() {                System.out.println(1);                c.countDown();                System.out.println(2);                c.countDown();            }        });        t.start();        t.join();       // c.await();        System.out.println("3");    }}