package 剑指offer;

import java.util.Arrays;

/**
 * @program: leet
 * @description: 最少的硬币数目
 * @author: Tb
 * @create: 2021-12-27 17:51
 **/
public class offer2_103 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if(coins[j] <= i) dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
            }
        }
        return dp[amount] > amount? -1:dp[amount];
    }
}
