package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:    计数器
 * @author: LGD
 * @date:2022/7/14 15:39
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(8);

        for (int i = 1; i < 9; i++) {
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "go");
            },String.valueOf(i)).start();
        }

        try {
            countDownLatch.await();//等待计数器归零,说明上述所有线程都执行完毕,再执行后面的操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Close door");
    }
}
