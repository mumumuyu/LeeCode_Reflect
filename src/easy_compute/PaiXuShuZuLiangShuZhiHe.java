package easy_compute;

import java.util.Arrays;

/**
 * @Description:    排序数组两数之和
 * 不动脑，直接莽
 * 执行用时：225 ms, 在所有 Java 提交中击败了5.00%的用户
 * 内存消耗：41.7 MB, 在所有 Java 提交中击败了43.00%的用户
 *
 * 又看了看题目，说是排序后的数组，所以直接双指针
 * @author: LGD
 * @date:2022/7/18 11:35
 */
public class PaiXuShuZuLiangShuZhiHe {
    public static void main(String[] args) {
        int[] numbers = {1,2,4,6,10};
        int target = 8;
        System.out.println(Arrays.toString(twoSum2(numbers, target)));
    }

    //莽夫
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target)
                    return new int[]{i,j};
            }
        }
        return numbers;
    }

    //双指针
    public static int[] twoSum2(int[] numbers, int target) {
        int start = 0,end = numbers.length-1;
        int[] ints = new int[2];

        while(start < end){
            if(numbers[start]+ numbers[end] > target)
                end--;
            if(numbers[start]+ numbers[end] < target)
                start++;
            if (numbers[start]+ numbers[end] == target){
                ints[0] = start;
                ints[1] = end;
                break;
            }
        }
        return ints;
    }
}
