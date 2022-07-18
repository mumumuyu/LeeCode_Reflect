package juc;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description:
 * @author: LGD
 * @date:2022/7/15 16:37
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<String, String> function = s -> s+"lalala";

        new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        System.out.println(function.apply("str"));

        Predicate<String> predicate = s -> s.isEmpty();

/*        Predicate<String> predicate = new Predicate<String>(){
            @Override
            public boolean test(String str){
                return str.isEmpty();
            }
        };*/
        System.out.println(predicate.test("ss"));

        Consumer<String> consumer = s -> System.out.println(s);

        consumer.accept("sss");

        Supplier<String> supplier = () -> "ssss";

        System.out.println(supplier.get());
    }


}


