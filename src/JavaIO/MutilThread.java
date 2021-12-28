package JavaIO;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @program: leet
 * @description: 多线程信息
 * @author: Tb
 * @create: 2021-12-08 21:09
 **/
public class MutilThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] infos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo info : infos) {
            System.out.println("["+info.getThreadId()+"]"+info.getThreadName());
        }
    }
}
