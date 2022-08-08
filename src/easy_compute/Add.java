package easy_compute;

/**
 * @Description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @author: LGD
 * @date:2022/8/8 11:26
 */
public class Add {

    public static void main(String[] args) {
        System.out.println(add(1, 3));
    }

    public static int add(int a, int b) {
        while(b != 0){
            int c = (a&b) << 1;
            a = a^b;
            b = c;
        }
        return a;
    }
}
