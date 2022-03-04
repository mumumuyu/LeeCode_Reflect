package example;

/**
 * @ClassName: Reflect_test05
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/4  18:41
 */
public class Reflect_test05 {
    static {
        System.out.println("main init");
    }
    public static void main(String[] args) {

        System.out.println(Son.d);
    }
}

class Dad{
    static int d = 100;
    static{
        System.out.println("dad init");
    }
}

class Son extends Dad{
    static int s = 50;
    static {
        System.out.println("son init");
    }
}
