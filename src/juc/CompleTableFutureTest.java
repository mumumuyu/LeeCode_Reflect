package juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/19 14:13
 */
public class CompleTableFutureTest {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync (()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("延迟两秒后输出");
        });

        System.out.println("先输出");

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<Integer> async = CompletableFuture.supplyAsync(() -> {
            int i = 10/0;
            return 200;
        });
        try {
            System.out.println(async.whenComplete((t,v)->{
                System.out.println(t + " " + v );
            }).exceptionally((e)->{
                System.out.println(e.getMessage());
                return 500;
            }).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
