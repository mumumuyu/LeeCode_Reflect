package juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/20 15:28
 */
public class DeadLockDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        threadPoolExecutor.execute(()->{
            new MyDeadThread().run();
        });

        threadPoolExecutor.execute(()->{
            new MyDeadThread().run();
        });

        threadPoolExecutor.shutdown();
    }

}

class MyDeadThread implements Runnable{

    private static final String res1 = "res1";
    private static final String res2 = "res2";
    static int count = 1;
    @Override
    public void run() {
        if (count == 1) {
            count++;
            synchronized (res1) {
                System.out.println("拿到res1");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (res2){
                    System.out.println("拿到res2");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            synchronized (res2) {
                System.out.println("拿到res2");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (res1){
                    System.out.println("拿到res1");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
