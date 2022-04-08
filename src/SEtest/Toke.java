package SEtest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/8 16:18
 */
public class Toke implements Runnable {

    int toke = 10;

    @Override
    public void run() {
        while (true) {
            if (toke > 0) {
                System.out.println(Thread.currentThread().getName() + "拿到了第" + toke-- + "张票");
            } else {
                System.out.println("手慢了，没有了");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Toke toke = new Toke();
        new Thread(toke,"lgd1").start();
        new Thread(toke,"lgd2").start();
        new Thread(toke,"lgd3").start();

//        ExecutorService service =  Executors.newFixedThreadPool(5);
//        service.execute(new Toke());
//        service.execute(new Toke());
//        service.execute(new Toke());
//
//        service.shutdown();
    }
}
