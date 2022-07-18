package juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/18 16:53
 */
public class parellelTest {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        long count = 0L;
        for (Long i = 0L; i < 100_0000_0000L; i++) {
            count += i;
        }

        long end = System.currentTimeMillis();
        System.out.println(count  + " " + (end-start));//-5340232226128654848 19829

        long start2 = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0, 100_0000_0000L).parallel().reduce(0, Long::sum);//-5340232216128654848 449

        long end2 = System.currentTimeMillis();
        System.out.println(reduce  + " " + (end2-start2));

        new ForkJoinTask() {
            @Override
            public Object getRawResult() {
                return null;
            }

            @Override
            protected void setRawResult(Object value) {

            }

            @Override
            protected boolean exec() {
                return false;
            }
        };

        ForkJoinPool pool = new ForkJoinPool();

    }
}
