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
/*        int[] num = {6,5,4,3,2,1};
        int[] ints = Arrays.stream(num).sorted().limit(3).toArray();
        System.out.println(Arrays.toString(ints));*/
        int[] num = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray3(num));
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

    //连续子数组最大和
    public int maxSubArray(int[] nums) {
        int pre = 0,max = 0;
        for (int num: nums){
            pre = Math.max(pre,pre+num);//找到最大前缀和
            max = Math.max(pre,max);
        }
        return max;
    }

    //前缀和
    public static int maxSubArray3(int[] nums) {
        int min = 0,max = Integer.MIN_VALUE,sum = 0;
        for (int num: nums){
            sum += num;
            max = Math.max(max,sum - min);
            min = Math.min(min,sum);
        }
        return max;
    }

    //超时...
    public static int maxSubArray2(int[] nums) {
        if(nums.length < 2) return nums[0];
        int count = 0;
        int mmax = 0;
        for (int num :nums){
            if (num >= 0) count ++;
            mmax = Math.max(num,mmax);
        }
        if (count == 0)
            return mmax;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int smax = 0;
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                smax = Math.max(sum,smax);
            }
            max = Math.max(max,smax);
        }
        return max;
    }
}
