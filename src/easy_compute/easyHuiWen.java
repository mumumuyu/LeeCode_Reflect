package easy_compute;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description:    有效回文    使用正则表达去除字符中除去字母与数字 其余莽夫
 * 执行用时：13 ms, 在所有 Java 提交中击败了7.73%的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了8.22%的用户
 * @author: LGD
 * @date:2022/7/24 15:32
 */
public class easyHuiWen {
    public static void main(String[] args) {
        /*String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));*/
/*        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(new DeadTest());
        threadPoolExecutor.execute(new DeadTest());
        threadPoolExecutor.execute(new DeadTest());
        threadPoolExecutor.shutdown();*/
/*        new Thread(new DeadTest()).start();
        new Thread(new DeadTest()).start();*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.stream().sorted((pre, next) -> -1).mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPalindrome(String s) {
        String replace = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        for (int i = 0; i < replace.length()/2; i++) {
            if (replace.charAt(i) != replace.charAt(replace.length()-i-1))
                return false;
        }
        return true;
    }
}

class DeadTest implements Runnable{
    static Integer one = 1;
    static Integer two = 2;
    static Boolean flag = true;

    @Override
    public void run() {
        if(flag){
            flag = false;
            synchronized (one){
                System.out.println("获取one");
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (two){
                    System.out.println("获取two");
                }
            }
        }else{
            synchronized (two){
                System.out.println("获取two");
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (one){
                    System.out.println("获取one");
                }
            }
        }
    }
}
