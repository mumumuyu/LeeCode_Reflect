package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 *
 * 给定一个非负整数数组nums，nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当nums[i] 为奇数时，i也是 奇数 ；当nums[i]为偶数时， i 也是 偶数 。
 *
 * @author: LGD
 * @date:2022/9/6 15:16
 */
public class SortArrayByParityB {
    public static void main(String[] args) {
        Arrays.stream(sortArrayByParityII2(new int[]{2, 3, 4, 5, 6,7})).forEach(System.out::println);
    }

    /** 冒泡屎山代码甚至更慢
     * 执行用时：5 ms, 在所有 Java 提交中击败了11.07%的用户
     * 内存消耗：43.8 MB, 在所有 Java 提交中击败了43.64%的用户
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
        //直接冒泡！
        for (int i = 0; i < nums.length-1; i++) {
            //i 为偶数
            if( i % 2 == 0){
                if (nums[i] % 2 == 0) {
                    continue;
                }else{
                    for (int j = i; j < nums.length; j++) {
                        if(nums[j] % 2 == 0){
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                }
            }else{
                if (nums[i] % 2 != 0) {
                    continue;
                }else{
                    for (int j = i; j < nums.length; j++) {
                        if(nums[j] % 2 != 0){
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                }
            }
        }
        return nums;
    }

    /** 算了，不折腾了，更慢了= =，虽然easy
     * 执行用时：44 ms, 在所有 Java 提交中击败了5.96%的用户
     * 内存消耗：45.4 MB, 在所有 Java 提交中击败了5.00%的用户
     * @param nums
     * @return
     */
    public static int[] sortArrayByParityII2(int[] nums) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> ouList = new ArrayList<>();
        for (int num:nums){
            //偶数
            if ((num - 0) % 2 == 0) {
                ouList.add(num);
            }else{
                oddList.add(num);
            }
        }
        int[] news = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if( i % 2 == 0){
                news[i] = oddList.remove(0);
            }else{
                news[i] = ouList.remove(0);
            }
        }
        return news;
    }
}
