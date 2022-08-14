package strings;

/**
 * @Description:    字符分割，左0分+1，右1分+1
 * 执行用时：1 ms, 在所有 Java 提交中击败了94.26%的用户
 * 内存消耗：39.6 MB, 在所有 Java 提交中击败了43.92%的用户
 * @author: LGD
 * @date:2022/8/14 20:22
 */
public class maxScore {
    public static void main(String[] args) {
        System.out.println(maxScore("01011001"));
    }

    public static int maxScore(String s) {
        int n = s.length();
        int n0 = 0,n1=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                n1++;
            }
        }
        int max = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                n0++;
            } else {
                n1--;
            }
            max = Math.max(max,n0 + n1);
        }
        return max;

    }
}
