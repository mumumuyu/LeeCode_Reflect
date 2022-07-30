package easy_compute;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 排序算法
 * @author: LGD
 * @date:2022/4/10 20:41
 */
public class Sort_Test {
    public static void main(String[] args) {
        long l1 = 0,l2=0,l3=0,l4=0,l5=0,l6=0,l7=0,l8=0;
        for (int i = 0; i < 50; i++) {
            ArrayList<Integer> lists = new ArrayList();
            for (int j = 0; j < 5000; j++) {
                lists.add((int) (Math.random()*10000));
            }
            int[] nums2 = lists.stream().mapToInt(x -> x).toArray();
            int[] nums3 = nums2;
            int[] nums4 = nums2;
            int[] nums5 = nums2;
            l1 += System.currentTimeMillis();
            bubble(nums2);
            l2 += System.currentTimeMillis();
//        for (int num:nums2)
//            System.out.println(num);
            l3 += System.currentTimeMillis();
            insert(nums3);
            l4 += System.currentTimeMillis();

            l5 += System.currentTimeMillis();
            quickSort(nums4,0,nums2.length-1);
            l6 += System.currentTimeMillis();

            l7 += System.currentTimeMillis();
            choose(nums5);
            l8 += System.currentTimeMillis();
        }


        System.out.println("冒泡共计"+(l2-l1)/50);
        System.out.println("直接插入共计"+(l4-l3)/50);
        System.out.println("快速排序共计"+(l6-l5)/50);
        System.out.println("直接选择共计"+(l8-l7)/50);
    }

    /**
     * 冒泡
     *
     *
     */
    public static void bubble(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 二分查找，先排序，再查找
     *
     *
     */
    public static int twoDivide(int[] nums,int target){
        if ((nums == null)||(nums.length==0)){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left<right){
            int mid = (left + right) >> 1;
            if(nums[mid]>target){
                right = mid - 1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return target == nums[left]? left : -1;
    }

    /**
     * 选择
     *
     *
     */
    public static void choose(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            int target = nums[i];
            int min = nums[i];
            int minTarget = i;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]<min){
                    min = nums[j];
                    minTarget = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minTarget];
            nums[minTarget] = temp;
        }
    }

    /**
     * 插入
     *
     *
     */
    public static void insert(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int j = i - 1;
//            while(j>=0 && nums[j]<target) {
//                nums[j+1] = nums[j];
//            }
            for (j=i-1; j >= 0 && nums[j]>target; j--) {
                    nums[j+1] = nums[j];
            }
            nums[j+1]= target;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort3(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort3(arr, low, j-1);
        //递归调用右半数组
        quickSort3(arr, j+1, high);
    }

    /**
     * 快速排序之自己来
     * 记得给自己出口
     * 一定要从j--开始
     */
    public static void quickSort(int[] nums,int low,int high){
        int i,j,temp,temp2;
        if(low>high){
            return;
        }
        i = low;
        j = high;
        temp = nums[low];
        while(i<j){
            while(i<j && temp<=nums[j]){
                j--;
            }
            while(i<j && temp>=nums[i]){
                i++;
            }
            if(i<j){
                temp2 = nums[j];
                nums[j] = nums[i];
                nums[i] = temp2;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;

        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }

    /**
     * 堆排序
     */

}
