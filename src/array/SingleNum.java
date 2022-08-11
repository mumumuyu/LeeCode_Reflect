package array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description: 只有两个数字只出现1次，其余都出现两次
 * @author: LGD
 * @date:2022/8/10 15:53
 */
public class SingleNum {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了6.61%的用户
     * 内存消耗：42.7 MB, 在所有 Java 提交中击败了85.75%的用户
     */
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> lists = new ArrayList<>();
        for (Integer i:map.keySet()){
            if(map.get(i) == 1)
                lists.add(i);
        }
        return lists.stream().mapToInt(o -> o).toArray();
    }
}
