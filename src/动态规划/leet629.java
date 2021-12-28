package 动态规划;

import java.util.Arrays;

public class leet629 {
    public int kInversePairs(int n, int k) {



        int[][] dp = new int[n+1][k+1];
        int[][] sum = new int[n+1][k+1];
        int mod = (int)1e9+7;
        dp[1][0] = 1;
        Arrays.fill(sum[1],1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = j < i ? sum[i-1][j] : (sum[i-1][j] - sum[i-1][j-(i-1)-1])%mod;
                sum[i][j] = j==1 ? dp[i][j] : (sum[i][j-1]+dp[i][j])%mod;
            }
        }
        return dp[n][k];
    }
}
