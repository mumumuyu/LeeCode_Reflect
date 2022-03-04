package example;

/**
 * @ClassName: SClassLoader
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/4  18:49
 */
public class SClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        ClassLoader classLoader = Class.forName("example.SClassLoader").getClassLoader();
        System.out.println(classLoader);

        System.out.println(System.getProperty("java.class.path"));
    }
}
