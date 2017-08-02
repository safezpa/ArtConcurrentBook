package myThreadTest;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MutiThread {

    public static void main(String[] args) {


        //Java 线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true,
                true);
        //Thread.currentThread().interrupt();

        //遍历线程信息，打印线程ID和线程名称
        for (ThreadInfo t:threadInfos) {
            System.out.println("["+t.getThreadId()+"]:"+t.getThreadName());
            System.out.println(Thread.currentThread().isInterrupted());
        }

    }

}
