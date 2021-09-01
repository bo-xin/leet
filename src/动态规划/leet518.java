package 动态规划;
/*
给定不同面额的硬币和一个总金额。
写出函数来计算可以凑成总金额的硬币组合数。
假设每一种面额的硬币有无限个。
 */
public class leet518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <=n ; i++) {
            int coin = coins[i-1];
            for (int j = 1; j <=amount ; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= coin){
                    dp[i][j] += dp[i][j-coin];
                }
            }
        }
        return dp[n][amount];
    }
    public int change1(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for (int i = coin; i <=amount ; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
