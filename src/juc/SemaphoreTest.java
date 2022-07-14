package juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description:    可以用于限流
 *                  参考操作系统设计的信号量：限制一个代码块只能被n个线程拿到,
 *                  - 当n>0时表示还有n个可用进程
 *                  - n=0表示可用进程为0
 *                  - n<0表示资源占满，有n个进程进入等待队列。(OS中解决互斥同步问题)
 * @author: LGD
 * @date:2022/7/14 16:10
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            final int temp = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(temp + "抢到了");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(temp + "离开了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }

}
