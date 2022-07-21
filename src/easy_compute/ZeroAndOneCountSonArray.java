package easy_compute;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:    0,1个数相同子数组
 * @author: LGD
 * @date:2022/7/21 9:05
 */
public class ZeroAndOneCountSonArray {
    public static void main(String[] args) {
        int[] nums = {0,1,0,0,1};
        System.out.println(findMaxLength(nums));
    }

    //寄,莽夫直接超时
    public static int findMaxLength2(int[] nums) {
        if(nums.length <= 1 || nums == null)
            return 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int zero = 0,one = 0,count = 0;
            for (int j = i ; j < nums.length; j++) {
                if(nums[j] == 0){
                    zero ++;
                }else{
                    one ++;
                }
                if(zero == one){
                    count = zero + one;
                    maxCount = Math.max(count,maxCount);
                }
            }
        }
        return maxCount;
    }

    //来点前缀和
    public static int findMaxLength(int[] nums) {
        /**
         将数组中的0换成-1， 求和为0的最长子数组 转换成前缀和问题
         */
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0, sum = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }else
                map.put(sum, i);
        }
        return ans;
    }
}
