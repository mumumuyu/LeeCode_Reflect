package example;

import java.lang.annotation.ElementType;

/**
 * @ClassName: Reflect_Test04
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/4  18:17
 */
public class Reflect_Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        A a = new A();
        System.out.println(A.m);
    }
}

class A{
    static{
        System.out.println("init");
        m=300;
    }
    static int m = 100;
    public A(){
        System.out.println("无参初始化");
    }
}