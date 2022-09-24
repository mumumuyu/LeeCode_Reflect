package array;

import java.util.Arrays;

/**
 * @Description:
 * 执行用时：1 ms, 在所有 Java 提交中击败了81.43%的用户
 * 内存消耗：41.5 MB, 在所有 Java 提交中击败了53.22%的用户
 * @author: LGD
 * @date:2022/9/24 17:30
 */
public class Decrypt {
    public static void main(String[] args) {
        int[] decrypt = decrypt(new int[]{1, 2, 3}, 1);
        Arrays.stream(decrypt).forEach(System.out::println);
    }

    public static int[] decrypt(int[] code, int k) {
        int[] dec = new int[code.length];
        if(k == 0){
            return dec;
        }
        int[] nums = new int[code.length*2];
        System.arraycopy(code,0,nums,0,code.length);
        System.arraycopy(code,0,nums,code.length,code.length);
        if(k > 0){
            for (int i = 0; i < code.length; i++) {
                int m = k;
                while(m>0) {
                    dec[i] += nums[i+m];
                    m--;
                }
            }
        }else{
            for (int i = code.length; i < nums.length; i++) {
                int m = -k;
                while(m>0) {
                    dec[i-code.length] += nums[i-m];
                    m--;
                }
            }
        }
        return dec;
    }
}
