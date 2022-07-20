package juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/20 10:14
 */
public class SpinlockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();

        // 自旋锁
        while(!atomicReference.compareAndSet(null,thread)){

        }

        System.out.println(thread.getName() + " lock");
    }

    // 解锁
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName() + " unlock");
    }

    public static void main(String[] args) {
        SpinlockDemo spinlockDemo = new SpinlockDemo();

        spinlockDemo.myUnlock();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(()->{
            spinlockDemo.myLock();
            try{
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinlockDemo.myUnlock();
            }
        });

        threadPoolExecutor.execute(()->{
            spinlockDemo.myLock();
            try{
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                spinlockDemo.myUnlock();
            }
        });
        threadPoolExecutor.shutdown();
    }

}
