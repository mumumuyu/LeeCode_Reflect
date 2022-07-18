package easy_compute;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:    找到只出现一次的数
 * 执行用时：5 ms, 在所有 Java 提交中击败了38.39%的用户
 * 内存消耗：40.8 MB, 在所有 Java 提交中击败了68.73%的用户
 * @author: LGD
 * @date:2022/7/18 10:59
 */
public class FindOneCountNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for(Integer i: map.keySet()){
            if(map.get(i) == 1)
                return i;
        }
        return 0;
    }
}
