package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * 返回交换 任意 次之后 num 的 最大 可能值。
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了58.97%的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了51.38%的用户
 * @author: LGD
 * @date:2022/9/6 14:06
 */
public class LargestInteger {
    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
    }

    public static int largestInteger(int num) {
        String s = String.valueOf(num);
        List<Integer> oddList = new ArrayList<>();
        List<Integer> ouList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c:chars){
            //偶数
            if ((c - '0') % 2 == 0) {
                ouList.add((int) c);
            }else{
                oddList.add((int) c);
            }
        }

        Collections.sort(oddList);
        Collections.sort(ouList);

        int oddCount = oddList.size() - 1;
        int ouCount = ouList.size() - 1;

        StringBuilder stringBuilder = new StringBuilder();
        for (char c:chars){
            //偶数
            if ((c - '0') % 2 == 0) {
                stringBuilder.append(ouList.get(ouCount--) - 48);
            }else{
                stringBuilder.append(oddList.get(oddCount--) - 48);
            }
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
