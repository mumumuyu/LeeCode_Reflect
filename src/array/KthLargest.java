package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * 来点无脑写法
 * 执行用时：1326 ms, 在所有 Java 提交中击败了5.04%的用户
 * 内存消耗：49.1 MB, 在所有 Java 提交中击败了
 * 5.04%
 * 的用户
 * @author: LGD
 * @date:2022/9/14 16:23
 */
class KthLargest {

    List<Integer> ints;

    int limit ;

    public KthLargest(int k, int[] nums) {
        limit = k;
        ints = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
    }

    public int add(int val) {
        //这里用直接插入法会更快
        ints.add(val);
        Collections.sort(ints);
        return ints.size() < limit ? ints.get(0):ints.get(ints.size()-limit);
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{4, 3, 2, 1});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(4));
        System.out.println(kthLargest.add(5));
    }
}
