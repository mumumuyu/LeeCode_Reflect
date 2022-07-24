package easy_compute;

import java.util.Locale;

/**
 * @Description:    有效回文    使用正则表达去除字符中除去字母与数字 其余莽夫
 * 执行用时：13 ms, 在所有 Java 提交中击败了7.73%的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了8.22%的用户
 * @author: LGD
 * @date:2022/7/24 15:32
 */
public class easyHuiWen {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        String replace = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        for (int i = 0; i < replace.length()/2; i++) {
            if (replace.charAt(i) != replace.charAt(replace.length()-i-1))
                return false;
        }
        return true;
    }
}
