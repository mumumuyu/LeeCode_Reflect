package example;

/**
 * @Description:
 * @author: LGD
 * @date:2022/8/11 15:14
 */
abstract class AbstractTest {

    //抽象类也可以有实现方法
    public static void test(){
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        test();
    }
}
