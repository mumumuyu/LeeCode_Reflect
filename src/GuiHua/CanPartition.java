package GuiHua;

import java.util.Arrays;

/**
 * @Description:
 * 给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。
 * 背包问题
 * 执行用时：30 ms, 在所有 Java 提交中击败了37.11%的用户
 * 内存消耗：42.4 MB, 在所有 Java 提交中击败了36.09%的用户
 * @author: LGD
 * @date:2022/9/30 9:37
 */
public class CanPartition {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
    }

    public static boolean canPartition(int[] nums) {
        if(nums.length<2)
            return false;
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        int target = sum/2;
        if(sum%2!=0 || max > sum/2)
            return false;
        boolean[][] dp = new boolean[nums.length][target+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j>=num){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
