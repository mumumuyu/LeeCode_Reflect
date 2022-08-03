package easy_compute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * 执行用时：7 ms, 在所有 Java 提交中击败了5.90%的用户
 * 内存消耗：49.8 MB, 在所有 Java 提交中击败了5.08%的用户
 * @author: LGD
 * @date:2022/8/3 9:20
 */
public class Exchange {
    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(exchange(num)));
    }

    public static int[] exchange(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 1) {
                list.add(nums[i]);
                nums[i] = -1;
            }
        }

        for (int num : nums) {
            if (num != -1) {
                list.add(num);
            }
        }

        int[] ints = list.stream().mapToInt(o -> o).toArray();
        return ints;
    }
}
