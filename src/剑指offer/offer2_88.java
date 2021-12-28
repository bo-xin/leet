package 剑指offer;

/**
 * @program: leet
 * @description: 爬楼梯最少成本
 * @author: Tb
 * @create: 2021-12-21 09:55
 **/
public class offer2_88 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }

}
