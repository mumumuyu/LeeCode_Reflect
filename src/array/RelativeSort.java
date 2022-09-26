package array;

import java.util.HashMap;

/**
 * @Description:
 *
 * 给定两个数组，arr1 和arr2，
 *
 * arr2中的元素各不相同
 * arr2 中的每个元素都出现在arr1中
 * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
 *
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40.1 MB, 在所有 Java 提交中击败了68.72%的用户
 * @author: LGD
 * @date:2022/9/26 17:09
 */
public class RelativeSort {
    public static void main(String[] args) {
        int[] arr1 = new  int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        System.out.println(relativeSortArray(arr1, arr2));
    }

    //不用Map了，数字不大直接用桶来做
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] count = new int[1001],res = new int[arr1.length];
        for (int num:arr1){
            count[num]++;
        }
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            int val = arr2[i];
            while(count[val]>0){
                res[k] = val;
                k++;
                count[val]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i]>0){
                while(count[i]>0){
                    res[k]=i;
                    k++;
                    count[i]--;
                }
            }
        }
        return res;
    }
}
