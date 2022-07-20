package juc;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description: CAS compareAndSet 比较与交换
 * CAS 是CPU的并发原语 , java无法调用内存，但是可以用native调用C++，C++可以操作内存，通过Unsafe类可以操作内存
 * @author: LGD
 * @date:2022/7/20 9:00
 */
public class CASDemo {

    public static void main(String[] args) {
        /*AtomicInteger atomicInteger =  new AtomicInteger(2022);

        // public final boolean compareAndSet(int expect, int update) 期望，更新值 修改成功true
        atomicInteger.compareAndSet(2022,2033);
        System.out.println(atomicInteger.get());*/

        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(101, 1);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 5000, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(()->{
            Integer reference = stampedReference.getReference();
            System.out.println("A1 " + stampedReference.getReference() + " "  + reference);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("A2 "  +stampedReference.compareAndSet(101, 103, stampedReference.getStamp(), stampedReference.getStamp() + 1));
            System.out.println("A2 " + stampedReference.getReference() + " "+ stampedReference.getStamp());


            System.out.println("A3 "  +stampedReference.compareAndSet(103, 101, stampedReference.getStamp(), stampedReference.getStamp() + 1));
            System.out.println("A3 " + stampedReference.getReference()+ " " + stampedReference.getStamp());
        });

        threadPoolExecutor.execute(()->{
            Integer reference = stampedReference.getReference();
            System.out.println("B1 " + + stampedReference.getReference() + " "+ reference);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("B2 "  + stampedReference.compareAndSet(101, 111, stampedReference.getStamp(), stampedReference.getStamp() + 1));
            System.out.println("B2 " + stampedReference.getReference() + " "+ stampedReference.getStamp());
        });

        threadPoolExecutor.shutdown();
    }
}
