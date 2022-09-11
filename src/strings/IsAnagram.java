package strings;

import java.util.Arrays;
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

    /**同哈希表升级版,不需要两个表，麻烦了
     * ??? 怎么这玩意儿比我暴力解法还慢，空间要得更多???
     * 执行用时：14 ms, 在所有 Java 提交中击败了19.80%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了5.02%的用户
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length()!= t.length() || s.equals(t))
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        char[] chars2 = t.toCharArray();
        for (char c : chars2){
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)<0)
                return false;
        }
        return true;
    }

    /**排序
     *执行用时：2 ms, 在所有 Java 提交中击败了88.78%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了89.99%的用户
     */
    public boolean isAnagram3(String s, String t) {
        if (s.length()!= t.length() || s.equals(t))
            return false;
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        String s2 = String.valueOf(chars);
        String s1 = String.valueOf(chars1);
        return s1.equals(s2);
    }
}
