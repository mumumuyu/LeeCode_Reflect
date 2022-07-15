package juc;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/15 14:44
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        SynchronousQueue<Object> queue = new SynchronousQueue<>();
//        Executors.newFixedThreadPool()
        new Thread(()->{
            try {
                Thread.sleep(3);
                System.out.println(Thread.currentThread().getName() + "put 1");
                queue.put("1");
                Thread.sleep(3);
                System.out.println(Thread.currentThread().getName() + "put 2");
                queue.put("2");
                Thread.sleep(3);
                System.out.println(Thread.currentThread().getName() + "put 3");
                queue.put("3");
                Thread.sleep(3);
                System.out.println(Thread.currentThread().getName() + "put 4");
                queue.put("4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"存").start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+queue.take());
                System.out.println(Thread.currentThread().getName()+queue.take());
                System.out.println(Thread.currentThread().getName()+queue.take());
                System.out.println(Thread.currentThread().getName()+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"取").start();
    }
}
