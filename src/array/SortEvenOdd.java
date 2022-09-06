package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 *
 * 给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值：偶数大到小，奇数小到大
 * 按 非递增 顺序排列 nums 奇数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对奇数下标的值排序后变为 [4,3,2,1] 。奇数下标 1 和 3 的值按照非递增顺序重排。
 * 按 非递减 顺序排列 nums 偶数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。偶数下标 0 和 2 的值按照非递减顺序重排。
 * 返回重排 nums 的值之后形成的数组。
 *
 * 执行用时：6 ms, 在所有 Java 提交中击败了23.17%的用户
 * 内存消耗：41.4 MB, 在所有 Java 提交中击败了89.19%的用户
 * @author: LGD
 * @date:2022/9/6 15:51
 */
public class SortEvenOdd {
    public static void main(String[] args) {
        Arrays.stream(sortEvenOdd(new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }

    public static int[] sortEvenOdd(int[] nums) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> ouList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //偶数
            if (i % 2 == 0) {
                ouList.add(nums[i]);
            }else{
                oddList.add(nums[i]);
            }
        }
        Collections.sort(oddList,(a,b)->b-a);
        Collections.sort(ouList);

        int[] news = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if( i % 2 == 0){
                news[i] = ouList.remove(0);
            }else{
                news[i] = oddList.remove(0);
            }
        }

        return news;
    }
}
