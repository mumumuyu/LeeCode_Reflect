package strings;


/**
 * @Description:
 * 这题目写得也忒抽象了，查字典嘛，a~z 变成题目序列而已
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了69.89%的用户
 * @author: LGD
 * @date:2022/9/12 20:12
 */
public class IsAlianSorted {
    public static void main(String[] args) {
        String[] strings = new String[]{"apap","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(strings,order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        //建个Hash表
        int[] dic = new int[order.length()];
        char[] chars = order.toCharArray();
        int count = 0;
        for(char c:chars){
            dic[c-'a'] = count ++;
        }
        for (int i = 1; i < words.length; i++) {
            boolean isLonger = false;

            for (int j = 0; j < words[i-1].length() && j < words[i].length(); j++) {
                if (dic[words[i-1].charAt(j) - 'a'] == dic[words[i].charAt(j) - 'a']){
                    isLonger = true;
                    continue;
                }else if (dic[words[i-1].charAt(j) - 'a'] < dic[words[i].charAt(j) - 'a']){
                    isLonger = false;
                    break;
                }else if (dic[words[i-1].charAt(j) - 'a'] > dic[words[i].charAt(j) - 'a']){
                    return false;
                }
            }

            if (isLonger && words[i-1].length() > words[i].length())
                return false;
        }
        return true;
    }
}
