package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:    连续正数序列
 * 执行用时：1 ms, 在所有 Java 提交中击败了98.27%的用户
 * 内存消耗：39.7 MB, 在所有 Java 提交中击败了20.70%的用户
 * @author: LGD
 * @date:2022/8/6 19:49
 */
public class ContinuousSequence {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }

    // 滑动窗口
    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> ints = new ArrayList<>();
        int r = 1, sum = 0;
        for (int l = 1;r<=(target/2+1);r++){
            sum += r;
            while(sum > target){
                sum -= l++;
            }
            if(sum == target){
                int[] num = new int[r-l+1];
                for (int i = 0; i <= r-l; i++) {
                    num[i] = l+i;
                }
                ints.add(num);
            }
        }

        int[][] res = new int[ints.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = ints.get(i);
        }
        return res;
    }
}
