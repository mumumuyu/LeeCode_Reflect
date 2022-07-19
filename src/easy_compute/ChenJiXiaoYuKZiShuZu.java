package easy_compute;

import java.util.Arrays;

/**
 * @Description: 乘积小于K的子数组
 * 简简单单当个莽夫，三分钟干出来，双指针估计没学明白还
 * 执行用时：876 ms, 在所有 Java 提交中击败了13.93%的用户
 * 内存消耗：48 MB, 在所有 Java 提交中击败了36.05%的用户
 * @author: LGD
 * @date:2022/7/19 10:36
 */
public class ChenJiXiaoYuKZiShuZu {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK2(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = nums.length, product = 1, count = 0;
        while(start < end){
            product *= nums[start];

                if(product < k) {
                    count++;
                    product *= nums[start];
                    start++;
                }else{

            }
            start ++;
        }
        return count;
    }

    //giao,莽夫了
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if  (nums.length == 0 || nums == null){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                if(product < k){
                    count ++;
                }else{
                    break;
                }
            }
        }

        return count;
    }
}
