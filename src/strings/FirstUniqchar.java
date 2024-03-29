package strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:    第一个只出现一次的 , 直接字典
 * 执行用时：24 ms, 在所有 Java 提交中击败了42.02%的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了25.77%的用户
 * @author: LGD
 * @date:2022/8/4 14:43
 */
public class FirstUniqchar {
    public static void main(String[] args) {
//        System.out.println(firstUniqChar("lgggddd"));
//        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseLeftWords(new String("lgd123456"), 2));
    }

    public static char firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c:s.toCharArray()){
            if(map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }

    /**
     * 反转字符
     * 执行用时：5 ms, 在所有 Java 提交中击败了33.88%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了11.11%的用户
     */
    public static String reverseWords(String s) {
        String[] s1 = s.trim().split("\\s+");
//        List<String> list = Arrays.stream(s1).collect(Collectors.toList());
        Collections.reverse(Arrays.asList(s1));
//        StringBuilder stringBuilder = new StringBuilder();
        /*for(int i = list.size()-1;i>0;i--){
            stringBuilder.append(list.get(i) + " ");
        }
        stringBuilder.append(list.get(0));*/
//        return stringBuilder.toString();
        return String.join(" ",s1);
    }

    /** 左旋字符串
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.8 MB, 在所有 Java 提交中击败了7.19%的用户
     */
    public static String reverseLeftWords(String s, int n) {
        return String.join("",s.substring(n),s.substring(0,n));
    }
}
