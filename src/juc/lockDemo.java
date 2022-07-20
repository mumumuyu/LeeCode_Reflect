package juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/20 9:57
 */
public class lockDemo {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(()->{
            phone.sms();
        });
        threadPoolExecutor.execute(()->{
            phone.call();
        });
        threadPoolExecutor.shutdown();
    }
}

class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName() + "sms");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName() + "call");
    }

}
class Phone2{
    Lock lock = new ReentrantLock();
    public void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "sms");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            call();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void call(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "call");
        lock.unlock();
    }

}
