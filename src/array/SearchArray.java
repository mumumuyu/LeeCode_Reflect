package array;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description:
 * 数组中某元素出现次数
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：44.1 MB, 在所有 Java 提交中击败了83.33%的用户
 *
 * @author: LGD
 * @date:2022/8/5 16:19
 */
public class SearchArray {
    public static void main(String[] args) {
        int[] nums = {0,1,3,4};
        System.out.println(missingNumber2(nums));
    }

    public int search(int[] nums, int target) {
        int count = 0;
        for (int num: nums){
            if(num == target)
                count++;
        }
        return count;
    }

    public static int missingNumber(int[] nums) {
        if(nums.length == 1)
            return nums[0] == 0? 1 : 0;
        int node = 0;
        while(node < nums.length){
            if(nums[node+1] - nums[node] != 1)
                return nums[node] + 1;
            node ++;
        }
        return 0;
    }

    /**
     * 执行用时：10 ms, 在所有 Java 提交中击败了6.31%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了95.91%的用户
     */
    public static int missingNumber2(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<len+1;i++){
            map.put(i,1);
        }
        for (int num : nums){
            map.put(num,map.get(num)-1);
        }
        for (int num :map.keySet())
            if(map.get(num) == 1)
                return num;

        return 0;
    }
}
