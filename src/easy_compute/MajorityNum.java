package easy_compute;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description: 找到数组里超过一般的数字,无脑map莽
 * 执行用时：15 ms, 在所有 Java 提交中击败了11.60%的用户
 * 内存消耗：46.3 MB, 在所有 Java 提交中击败了22.20%的用户
 * @author: LGD
 * @date:2022/8/4 10:02
 */
public class MajorityNum {
    public static void main(String[] args) {
        int[] num = {6,5,4,3,2,1};
        int[] ints = Arrays.stream(num).sorted().limit(3).toArray();
        System.out.println(Arrays.toString(ints));
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>length/2)
                return num;
        }
        return 0;
    }

    //🤡了，超过一半排序后必定在中间
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了56.17%的用户
     * 内存消耗：44.9 MB, 在所有 Java 提交中击败了56.03%的用户
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //获取乱序数组最小k个
    /** 摆烂刀法
     *执行用时：14 ms, 在所有 Java 提交中击败了29.76%的用户
     * 内存消耗：43.4 MB, 在所有 Java 提交中击败了5.04%的用户
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null || arr.length == 0)
            return new int[0];
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }
}
