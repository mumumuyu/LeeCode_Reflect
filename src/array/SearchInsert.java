package array;

/**
 * @Description:
 * 给定一个排序的整数数组 nums和一个整数目标值 target ，请在数组中找到target，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author: LGD
 * @date:2022/9/14 17:26
 */
public class SearchInsert {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41 MB, 在所有 Java 提交中击败了52.56%的用户
     */
    public int searchInsert(int[] nums, int target) {
        int ind = nums.length - 1;
        while(ind >= 0){
            int num = nums[ind];
            if (target == num)
                return ind;
            if (target > num)
                return ind + 1;
            ind --;
        }
        return 0;
    }
}
