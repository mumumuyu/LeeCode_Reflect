package easy_compute;

/**
 * @Description:
 * @author: LGD
 * @date:2022/8/10 8:55
 */
public class MaxProfile {
    public static void main(String[] args) {

    }

    /**
     * 暴力
     * 这都能过= =
     * 执行用时：244 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗：41.4 MB, 在所有 Java 提交中击败了45.50%的用户
     */
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int min = prices[0];
        for (int j = 1; j < prices.length; j++) {
            if(prices[j] < min){
                min = prices[j];
            }else {
                maxPro = Math.max(maxPro, prices[j] - min);
            }
        }
        return maxPro;
    }

    /**
     * 简单改造，维护最小变量，其实本来打算用贪心的，按趋势得到低点与高点之差的和就是答案
     */
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        int maxPro = 0;
        int min = prices[0];
        for (int j = 1; j < prices.length; j++) {
            if(prices[j] < min){
                min = prices[j];
            }else {
                maxPro = Math.max(maxPro, prices[j] - min);
            }
        }
        return maxPro;
    }
}

