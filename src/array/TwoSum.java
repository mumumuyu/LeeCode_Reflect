package array;

import java.util.HashMap;

/**
 * @Description:    两数和
 * @author: LGD
 * @date:2022/8/6 17:31
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    //HashMap做法——内存消耗少
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,1);
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i]))
                return new int[]{nums[i],target-nums[i]};
        }

        return new int[0];
    }

    //二分
    public int[] twoSum2(int[] nums, int target) {
        for(int i = 0 ; i < nums.length;i++){
            int other = target - nums[i];
            int left = 1,right = nums.length - 1;
            while(left < right){
                int mid = (left + right) >> 1;
                if (nums[mid] == other) {
                    return new int[]{1, 2};
                }else if (nums[mid] > other){
                    right = mid;
                }else{
                    left = mid;
                }
            }
        }
        return new int[0];
    }

    //双指针——快
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 1)
            return new int[0];

        int left = 0 , right = nums.length - 1;
        //双指针
        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{nums[left] , nums[right]};
            }else if (nums[left] + nums[right] < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[0];
    }
}
