package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/15 11:37
 */
public class BlockingTest {
    public static void main(String[] args) {
        waitBlockingthrowException();
    }

    //抛出异常
    public static void throwException(){
        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<>(3);
        System.out.println(objects.add("a"));
        System.out.println(objects.add("a"));
        System.out.println(objects.add("a"));

        //Queue full,满了抛出异常
//        System.out.println(objects.add("a"));
        System.out.println(objects.remove());
        System.out.println(objects.remove());
        System.out.println(objects.remove());

        //NoSuchElementException没有了还remove抛出异常
//        System.out.println(objects.remove());
    }

    //不抛出异常
    public static void nothrowException(){
        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<>(3);
        System.out.println(objects.offer("a"));
        System.out.println(objects.offer("a"));
        System.out.println(objects.offer("a"));
        //false不抛出异常，返回false
        System.out.println(objects.offer("a"));

        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        // 取不到值返回null
        System.out.println(objects.poll());
    }

    //阻塞队列
    public static void BlockingthrowException() {
        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<>(3);
        try {
            objects.put("a");
            objects.put("b");
            objects.put("c");
            objects.put("d");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void waitBlockingthrowException() {
        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<>(3);
        objects.offer("a");
        objects.offer("b");
        objects.offer("c");
        try {
            objects.offer("d",2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        try {
            System.out.println(objects.poll(2, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
