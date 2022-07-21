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
/*        int[] nums = {1,2,1};
        int k = 2;
        System.out.println(subarraySum2(nums, k));*/
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5,2);
        System.out.println(map.getOrDefault(4, 0));
    }

    //滑倒了，不存在负数时可用滑动窗口 ,正整数+连续序列 可以用 😡好不容易会
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
    public static int subarraySum2(int[] nums, int k) {
        int count = 0,sum = 0;
        HashMap<Integer,Integer> maps = new HashMap<>();
        maps.put(0,1);
        for (int num:nums){
            sum += num;
            count += maps.getOrDefault(sum - k,0);
            maps.put(sum,maps.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
