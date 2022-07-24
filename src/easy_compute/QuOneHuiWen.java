package easy_compute;

/**
 * @Description: 删除一个变回文执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：42.1 MB, 在所有 Java 提交中击败了37.69%的用户
 * @author: LGD
 * @date:2022/7/24 15:47
 */
public class QuOneHuiWen {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome(s));
    }

    //试一下递归，有一次不同左边右移一位，右边左移一位继续
    public static boolean validPalindrome(String s) {
        return checkPalidrome(s,0,s.length()-1,false);
    }

    private static boolean checkPalidrome(String s, int left, int right, boolean b) {
        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                if (b){
                    return false;
                }else{
                    return checkPalidrome(s,left+1,right,true) || checkPalidrome(s,left,right-1,true);
                }
            }
            left++;
            right--;
        }
        return true;
    }


}
