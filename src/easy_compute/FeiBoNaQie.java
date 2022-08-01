package easy_compute;

/**
 * @Description:    斐波那契数列
 * @author: LGD
 * @date:2022/8/1 9:12
 */
public class FeiBoNaQie {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
         int[] dp = new int[n+1];
         dp[0]=0;
         dp[1]=1;
         int i = 2;
         while(i <= n){
             dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
             i++;
         }
         return dp[n];
    }
}
