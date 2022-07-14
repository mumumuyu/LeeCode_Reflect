package juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:    加数器，当数目达到一定时继续
 * @author: LGD
 * @date:2022/7/14 15:49
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(9,()->{
            System.out.println("成功升至九五至尊");
        });

        for (int i = 1; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"个");
                try {
                    cyclicBarrier.await();// + 1 等待到 9
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
