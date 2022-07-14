package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/14 15:17
 */
public class CallabelTest {
    public static void main(String[] args) {
        //Callable,FutureTask实现了Runnable接口的子接口RunnableFuture
//        RunnableFuture;
//        FutureTask;
        MyThread myThread = new MyThread();
        //适配类 FutrueTask
        FutureTask futureTask = new FutureTask(myThread);

        new Thread(futureTask,"threadA").start();

        try {
            String result = (String) futureTask.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("call");
        return "success";
    }
}
