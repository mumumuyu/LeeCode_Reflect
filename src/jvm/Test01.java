package jvm;

/**
 * @Description:
 * @author: LGD
 * @date:2022/4/1 14:00
 */
public class Test01 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        Test01 test02 = new Test01();
        Test01 test03 = new Test01();

        System.out.println(test01.hashCode());
        System.out.println(test02.hashCode());
        System.out.println(test03.hashCode());
/*
1163157884
1956725890
356573597
new的三个地址肯定不一样
 */

        Class<? extends Test01> aClass1 = test01.getClass();

        ClassLoader classLoader = aClass1.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
/*
sun.misc.Launcher$AppClassLoader@18b4aac2
sun.misc.Launcher$ExtClassLoader@677327b6
null
各级类加载器
 */

        Class<? extends Test01> aClass2 = test02.getClass();
        Class<? extends Test01> aClass3 = test03.getClass();

        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
/*
460141958
460141958
460141958
类的模板，那当然一样
*/
    }
}
