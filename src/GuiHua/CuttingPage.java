package GuiHua;

/**
 * @Description:    剪绳子
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了47.61%的用户
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/submissions/ 参考爬楼梯的骚操作
 * @author: LGD
 * @date:2022/8/11 15:57
 */
public class CuttingPage {
    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }

    public static int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        int  a = 2,b = 3, c = 4,d = 6;

        for (int i = 0; i < n - 5; i++) {
            if(i % 3 == 0) {
                a = b ;
                b = c ;
                c = d ;
                d = (a * 3 )% 1000000007;
            }else{
                a = b ;
                b = c ;
                c = d ;
                d = (b * 2) % 1000000007;
            }
        }
        return d;
    }
    //递归版
    public static int PaLouTi(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        // return climbStairs(n-1) + climbStairs(n-2);
        int a = 1;
        int b = 2;
        int sum = a + b;
        int count = n - 3;
        while(count-- > 0){
            a = b;
            b = sum;
            sum = a + b;
        }
        return sum;
    }
}
