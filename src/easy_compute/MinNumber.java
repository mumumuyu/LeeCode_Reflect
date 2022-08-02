package easy_compute;

import java.util.Arrays;

/**
 * @Description: 旋转最小数组
 * @author: LGD
 * @date:2022/8/2 15:02
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] array = {1,3,5};
        System.out.println(minArray(array));
    }

    public static int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public static int minArray2(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            //只要右边比中间大，那右边一定是有序数组
            if (numbers[r] > numbers[mid]) {
                r = mid;
            } else if (numbers[r] < numbers[mid]) {
                l = mid + 1;
                //去重
            } else r--;
        }
        return numbers[l];
    }
}
