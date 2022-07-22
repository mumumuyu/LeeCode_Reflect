package easy_compute;

import java.util.Arrays;

/**
 * @Description:    中心下标
 * 执行用时：3 ms, 在所有 Java 提交中击败了30.48%的用户
 * 内存消耗：42.1 MB, 在所有 Java 提交中击败了49.17%的用户
 * @author: LGD
 * @date:2022/7/22 14:47
 */
public class ZhongXinXiaBiao {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (sum == current) return i;
            else current += nums[i];
        }

        return -1;
    }
}
