package example;

import java.lang.annotation.ElementType;

/**
 * @ClassName: Reflect_Test03
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/4  14:47
 */
public class Reflect_Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Object.class;//类
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;//一维数组
        Class c4 = int[][].class;//二维数组
        Class c5 = Override.class;//注解
        Class c6 = ElementType.class;//美剧
        Class c7 = Integer.class;//基本数据类型
        Class c8 = void.class;//void
        Class c9 = Class.class;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
    }
}