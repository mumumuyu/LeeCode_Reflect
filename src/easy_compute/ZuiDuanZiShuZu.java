package easy_compute;

import java.util.Arrays;

/**
 * @Description:    和大于等于 target 的最短子数组
 * 执行用时： 133 ms , 在所有 Java 提交中击败了 6.92% 的用户
 * 内存消耗：41.3 MB, 在所有 Java 提交中击败了53.85%的用户
 * @author: LGD
 * @date:2022/7/19 8:59
 */
public class ZuiDuanZiShuZu {
    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen2(target, nums));
    }

    //靠，没读好题,>=
    public static int minSubArrayLen(int target, int[] nums) {
        if  (target > Arrays.stream(nums).sum() || nums.length == 0 || nums == null){
            return 0;
        }

        int count = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int count2 = 0;
            int j = i;
            while(j<nums.length){
                count2 ++;
                sum += nums[j];
                if (sum >= target){
                    count = Math.min(count2,count);
                    break;
                }
                j++;
            }
        }

        return count == (nums.length + 1) ? 0 : count;
    }

    //滑动窗口
    public static int minSubArrayLen2(int target, int[] nums) {
        int start = 0, end = 0, sum = 0;
        int count = nums.length + 1;
        while(end < nums.length){
            sum += nums[end];
            while (sum >= target){
                count = Math.min(count,end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return count == nums.length + 1 ? 0 : count;
    }
}
