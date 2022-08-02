package easy_compute;

/**
 * @Description:
 * n-1个台阶有f(n-1)种跳法，最后还剩一个台阶，最后青蛙只能最后一跳
 * n-2个台阶有f(n-2)种跳法，最后剩余二个台阶，有两种跳法：
 *        ①一次跳两个台阶
 *        ②一次跳一个台阶  但是这种跳法其实已经在n-1个台阶里包含了，所以
 *  f(n)=f(n-1)+f(n-2)
 * @author: LGD
 * @date:2022/8/2 14:33
 */
public class NumWays {
    public static void main(String[] args) {
        System.out.println(numWays(4));
    }

    public static int numWays(int n) {
        if(n < 2)
            return 1;
        int a = 1, b = 1,sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    /**
     * hhh,这种写法直接超时,但是easy
     * @param n
     * @return
     */
    public int numWays2(int n) {
        if(n < 2)
            return 1;
        return (numWays2(n-1) + numWays2(n-2))%1000000007;
    }
}
