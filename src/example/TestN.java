package example;

/**
 * @Description:
 * @author: LGD
 * @date:2022/8/11 15:14
 */
public interface TestN {

    //接口也可以有实现方法
    default void test(){
        System.out.println("aaa");
    }
}
