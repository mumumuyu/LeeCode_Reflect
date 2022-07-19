package easy_compute;

import java.util.Arrays;

/**
 * @Description: 乘积小于K的子数组
 * 简简单单当个莽夫，三分钟干出来，双指针估计没学明白还
 * 执行用时：876 ms, 在所有 Java 提交中击败了13.93%的用户
 * 内存消耗：48 MB, 在所有 Java 提交中击败了36.05%的用户
 *
 * 滑动窗口机制：思路: 设存在数组nums=[A, B, C, D], k为乘积, count为符合条件的数组个数, i,j为窗口左右边界;
 *    (假设) A: A<k    i=j=0  --> count = A (0-0+1)
 *          B: AB<k   j=1    --> count = AB, B(1-0+1)
 *          C: ABC>=k j=2    --> BC<k i=1 --> count = BC, C (2-1+1)
 *          D: BCD>k  j=3    --> CD>K i=2 --> D < k i=3 --> count = D (3-3+1)
 *          当计算的数组乘积大于k时，将窗口左边界右移, 直到小于k, 计算count，窗口右边界右移；
 *          当计算的数组乘积小于k时，计算count，窗口右边界右移
 *          得出规律：每一次遍历count增加了j-i+1
 * @author: LGD
 * @date:2022/7/19 10:36
 */
public class ChenJiXiaoYuKZiShuZu {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    //滑动窗口，妙啊
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0, product = 1, count = 0;
        while (end < nums.length){
            product *= nums[end];
            //积>=k，左侧窗口右移
            while (start <= end && k <= product){
                product /= nums[start ++] ;
            }

            if(start <= end){
                count += end - start + 1;
            }
            end++;
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
