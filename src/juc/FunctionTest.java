package juc;

import java.util.function.Function;

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
    }
}
