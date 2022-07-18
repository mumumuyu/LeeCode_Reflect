package easy_compute;

/**
 * @Description:    单词最大乘积
 * 执行用时：2720 ms, 在所有 Java 提交中击败了5.00%的用户
 * 内存消耗：42.2 MB, 在所有 Java 提交中击败了5.07%的用户
 * 哈哈，总归是随便做出个中等难度的了，虽然执行效果不快
 * @author: LGD
 * @date:2022/7/18 11:15
 */
public class WordMaxJi {
    public static void main(String[] args) {
        String[] words = {"a","ab","ac"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String jiChu = words[i];
            for (int j = i+1; j < words.length; j++) {
                String now = words[j];
                max = Math.max(QuChongChenJi(jiChu,now),max);
            }
        }
        return max;
    }

    public static int QuChongChenJi(String a,String b){
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < a.length(); i++) {
            if(!b.contains(String.valueOf(a.charAt(i)))){
                count1 ++;
            }else{
                count1 = 0;
                break;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if(!a.contains(String.valueOf(b.charAt(i)))){
                count2 ++;
            }else{
                count2 = 0;
                break;
            }
        }
        return count1 * count2;
    }
}
