package easy_compute;

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
}
