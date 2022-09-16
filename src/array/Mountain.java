package array;

/**
 * @Description:
 * 山顶数组找顶峰
 * @author: LGD
 * @date:2022/9/15 8:50
 */
public class Mountain {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>arr[i+1])
                return i;
        }
        return 0;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int ans = 0,left = 1,right = arr.length - 2;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] >arr[mid+1]){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现int sqrt(int x)函数。
     * 正数的平方根有两个，只输出其中的正数平方根。
     * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
     */
    public static int mySqrt(int x) {
        int left = 0,right = x,ans= -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if((long)mid*mid<=x){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
