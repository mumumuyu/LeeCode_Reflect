package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/14 16:34
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //写
        for (int i = 1; i <=50; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"s",temp + "s");
            }).start();
        }

        //读
        for (int i = 1; i <=50; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"s");
            }).start();
        }
    }
}

class MyCache {
    private volatile Map<String,Object> map = new HashMap<>();

    void put(String key,Object value){
        System.out.println(Thread.currentThread().getName() + "写入" +key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    void get(String key){
        System.out.println(Thread.currentThread().getName() + "读取" +key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成");
    }
}

class MyCacheLock {
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //写只能一个线程写
    void put(String key,Object value){
        System.out.println(Thread.currentThread().getName() + "写入" +key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    //读可以多个线程去读
    void get(String key){
        System.out.println(Thread.currentThread().getName() + "读取" +key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成");
    }
}
