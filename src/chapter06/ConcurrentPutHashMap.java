/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package chapter06;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ²¢·¢put
 * 
 * @author tengfei.fangtf
 * @version $Id: Snippet.java, v 0.1 2015-7-31 ÏÂÎç11:53:55 tengfei.fangtf Exp $
 */
public class ConcurrentPutHashMap {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread[] th=new Thread[10000];

                for (int i = 0; i < 10000; i++) {
                   th[i]= new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i);
                     th[i].start();

                }

                for (int i = 0; i < 10000; i++) {
                    try {
                        //th[i].join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                for (int i = 0; i <10000 ; i++) {
                    System.out.println(th[i].getState());
                }

            }
        }, "ftf");
        t.start();

        t.join();
        System.out.println(t.getState());
        System.out.println("finished put");
        for (Map.Entry en:map.entrySet()
             ) {

            System.out.println(en.getKey()+":  "+en.getValue());

        }
    }



}
