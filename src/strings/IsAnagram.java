package strings;

import java.util.HashMap;

/**
 * @Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * 注意：若s 和 t中每个字符出现的次数都相同且字符顺序不完全相同，则称s 和 t互为变位词（字母异位词）。
 * @author: LGD
 * @date:2022/9/11 21:02
 */
public class IsAnagram {
    public static void main(String[] args) {

    }

    /**暴力
     * 执行用时：12 ms, 在所有 Java 提交中击败了23.99%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了22.25%的用户
     */
    public boolean isAnagram(String s, String t) {
        if (s.equals(t))
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars;
        if(s.length()>t.length()) {
            chars = s.toCharArray();
        }else{
            chars = t.toCharArray();
        }
        for (char c : chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] chars2;
        if(s.length()>t.length()) {
            chars2 = t.toCharArray();
        }else{
            chars2 = s.toCharArray();
        }
        for (char c : chars2){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }

        for(Character c:map.keySet()){
            if (!map.get(c).equals(map2.get(c)))
                return false;
        }
        return true;
    }
}
