package strings;

import java.util.HashMap;

/**
 * @Description: 字符串前缀匹配
 * @author: LGD
 * @date:2022/9/9 11:00
 */
public class LongestPrefix {
    public static void main(String[] args) {

    }

    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < strs[0].length();i++){
            char a = strs[0].charAt(i);
            for (int j = 1;j < strs.length; j++){
                if(strs[j].length() <= i || a != strs[j].charAt(i)){
                    return sb.length() == 0 ? "" : sb.toString();
                }
            }
            sb.append(a);
        }
        return sb.toString();
    }
}
