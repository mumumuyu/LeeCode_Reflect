package example;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Generic_Ref
 * @Description: TODO
 * @author: LGD
 * @date: 2022/3/5  14:05
 */
public class Generic_Ref {
    public void test1(Map<String,Son> map, List<Son> list){
        System.out.println("Test1");
    }

    public Map<String,Son> test2(){
        System.out.println("Test2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test1 = Generic_Ref.class.getMethod("test1", Map.class, List.class);

        Type[] genericParameterTypes = test1.getGenericParameterTypes();
        for(Type generic: genericParameterTypes) {
            System.out.println("@" + generic);
            if(generic instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) generic).getActualTypeArguments();
                for (Type typeargu:actualTypeArguments) {
                    System.out.println(typeargu);
                }
            }
        }

        Method test2 = Generic_Ref.class.getMethod("test2");
        Type genericReturnType = test2.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type typeargu:actualTypeArguments) {
                System.out.println(typeargu);
            }
        }
    }
}
