package GuiHua;

/**
 * @Description:
 * 动态规划，关键在找到规律
 * @author: LGD
 * @date:2022/9/30 9:11
 */
public class MinCostPaLouTi {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs2(new int[]{1, 100, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }

    //滚动数组优化,只与i-1,i-2相关，所以做留存
    public static int minCostClimbingStairs2(int[] cost) {
        int[] dp = new int[cost.length+1];
        int cur = 0,pre = 0,next = 0;
        for (int i = 2; i < dp.length; i++) {
            next = Math.min(cur + cost[i-1],pre+cost[i-2]);
            pre = cur;
            cur = next;
        }
        return next;
    }
}
