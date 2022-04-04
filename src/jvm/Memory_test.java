package jvm;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/3 21:08
 */
public class Memory_test {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();
        long l1 = Runtime.getRuntime().totalMemory();
        System.out.println(l/(double)(1024*1024));
        System.out.println(l1/(double)(1024*1024));
    }
}
