package example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {

        Field[] declaredFields = Son.class.getDeclaredFields();
        for(Field field:declaredFields)
            System.out.println(field);

        Method[] declaredMethods = Son.class.getDeclaredMethods();
        for(Method method: declaredMethods)
            System.out.println(method);

        Constructor<?>[] declaredConstructors = Son.class.getDeclaredConstructors();
        for(Constructor constructor:declaredConstructors)
            System.out.println(constructor);

        Class c1 = Class.forName("example.Son");

        Son lgd = (Son) c1.getDeclaredConstructor(String.class).newInstance("lgd");
        System.out.println(lgd);

        //反射获取类的方法并进行操作
        Son son = Son.class.newInstance();
        Method setName = Son.class.getDeclaredMethod("setName", String.class);
        setName.invoke(son,"lgd2");
        System.out.println(son);

        //反射获取类的成员变量并进行操作
        Son son1 = (Son) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);//关掉权限
        name.set(son1,"lgdaaa");
        System.out.println(son1);

    }
}

class Dad{
    static int d = 100;
    static{
        System.out.println("dad init");
    }
}

class Son extends Dad{
    private String name;
    static int s = 50;
    static {
        System.out.println("son init");
    }
    public void sonMethod(){

    }

    public Son(String name){
        this.name = name;
    }
    public Son(){
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;

    }
}
