package easy_compute;

import java.util.Arrays;

/**
 * @Description:    二进制1的个数
 * @author: LGD
 * @date:2022/7/18 10:28
 */
public class BitCountTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(8)));
    }

    public static int[] countBits(int n) {
        int[] ints = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ints[i] = countBit(i);
        }

        return ints;
    }

    public static int countBit(int n){
        String s = biaryToDemical(n);
        char[] chars = s.toCharArray();
        int count = 0;
        for(char c:chars){
            if(c == '1')
                count++;
        }
        return count;
    }

    public static String biaryToDemical(int n){
        StringBuilder stringBuilder = new StringBuilder();
        while(n!=0){
            stringBuilder.append(n % 2);

            n /= 2;
        }
        return stringBuilder.reverse().toString();
    }
}
