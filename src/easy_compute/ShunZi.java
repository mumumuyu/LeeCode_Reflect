package easy_compute;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description:    扑克牌顺子
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：39.3 MB, 在所有 Java 提交中击败了9.92%的用户
 * @author: LGD
 * @date:2022/8/8 9:00
 */
public class ShunZi {
    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {
        int min = 14;
        int max = 0;

        HashSet<Integer> sets = new HashSet<>();
        for (int num : nums){
            if(num == 0) continue;
            max = Math.max(max,num);
            min = Math.min(min,num);
            if(sets.contains(num))
                return false;
            sets.add(num);
        }

        return max - min < 5 ;
    }
}
