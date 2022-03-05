package example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName: Dir_Invoke_Dif
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/5  13:38
 */
public class Dir_Invoke_Dif {
    void Test1(){
        Son lgd = new Son("lgd");
        long starttime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            lgd.getName();
        }

        long endtime = System.currentTimeMillis();
        System.out.println("正常"+(endtime-starttime));
    }
    void Test2() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Son son = Son.class.newInstance();
        Method setName = Son.class.getDeclaredMethod("setName", String.class);
        Method getName = Son.class.getDeclaredMethod("getName");
        getName.setAccessible(true);
        setName.invoke(son,"lgd");
        long starttime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(son);
        }

        long endtime = System.currentTimeMillis();
        System.out.println("(反射)关闭权限验证:"+(endtime-starttime));
    }
    void Test3() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Son son = Son.class.newInstance();
        Method setName = Son.class.getDeclaredMethod("setName", String.class);
        Method getName = Son.class.getDeclaredMethod("getName");
        setName.invoke(son,"lgd");
        long starttime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(son);
        }

        long endtime = System.currentTimeMillis();
        System.out.println("(反射)不关权限验证:"+(endtime-starttime));
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Dir_Invoke_Dif dir_invoke_dif = new Dir_Invoke_Dif();
        dir_invoke_dif.Test1();
        dir_invoke_dif.Test2();
        dir_invoke_dif.Test3();
    }
}

