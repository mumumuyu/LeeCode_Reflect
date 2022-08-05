package strings;

import java.util.HashMap;

/**
 * @Description:    第一个只出现一次的 , 直接字典
 * 执行用时：24 ms, 在所有 Java 提交中击败了42.02%的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了25.77%的用户
 * @author: LGD
 * @date:2022/8/4 14:43
 */
public class FirstUniqchar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("lgggddd"));
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

}
