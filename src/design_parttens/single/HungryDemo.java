package design_parttens.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/19 16:52
 */
class Hungry {

    private volatile static Hungry hungry;
    private Hungry() {
        System.out.println(Thread.currentThread().getName() + " ok ");
    }
    //双重检测锁模式
    public static Hungry getInstance(){
        if (hungry == null) {
            synchronized (Hungry.class) {
                if (hungry == null)
                /**
                 * new 的过程分为3步
                 * 1.分配内存
                 * 2.创建实例
                 * 3.指向地址
                 *
                 * 如果指令可以重排
                 * 132C操作，那么B拿到的可能是Null，因为虽然指向了地址，但是此时还没有创建实例
                 */
                    hungry = new Hungry();
            }
        }
        return hungry;
    }

}
public class HungryDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Hungry instance = Hungry.getInstance();
        Hungry instance2 = Hungry.getInstance();

        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);

        EnumSingle enumSingle = constructor.newInstance();

    }
}

enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance(){
        return  INSTANCE;
    }
}
