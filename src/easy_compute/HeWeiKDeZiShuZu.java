package easy_compute;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:    和为k的子数组
 * @author: LGD
 * @date:2022/7/20 16:17
 */
public class HeWeiKDeZiShuZu {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    //滑倒了，不存在负数时可用滑动窗口 😡好不容易会
    public static int subarraySum(int[] nums, int k) {
        if (nums.length <= 0)
            return 0;
        int start = 0, end = 0, count = 0, sum = 0, n = nums.length;
        while(end < n){
            sum += nums[end];

            while(start < end){
                if( (sum > k && nums[start] >= 0) || (sum < k && nums[start] <=0)) {
                    sum -= nums[start++];
                }else {
                    break;
                }
            }

            if (sum == k)
                count++;

            end++;
        }
        return count;
    }

    //朴素前缀和
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();  // 前缀 -> 出现次数
        map.put(0, 1);  // 以防nums[0]就是k
        int pre = 0, cnt = 0;
        for (int n : nums) {
            pre += n;
            // 已知当前的前缀pre和之前某个前缀X，且要求pre-X=k，那么X=pre-k。X的出现次数就是此时以n结尾的子数组的合法次数
            cnt += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return cnt;
    }

}
