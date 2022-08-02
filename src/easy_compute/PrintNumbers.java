package easy_compute;

/**
 * @Description:    打印顺序数直到n位
 * 执行用时：2 ms, 在所有 Java 提交中击败了23.13%的用户
 * 内存消耗：49.2 MB, 在所有 Java 提交中击败了38.29%的用户
 * @author: LGD
 * @date:2022/8/2 9:51
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        for (int i = 0; i < n; i++) {
            stringBuilder.append(0);
        }
        Long aLong = Long.valueOf(stringBuilder.toString());
        int[] ints = new int[Math.toIntExact(aLong-1)];
        for (int i = 1; i < aLong; i++) {
            ints[i-1] = i;
        }
        return ints;
    }

}
