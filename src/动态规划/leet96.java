package 动态规划;

public class leet96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < i/2; j++) {
                    dp[i] += 2 * dp[j]*dp[i-j-1];
                }
            }else {
                for (int j = 0; j < i/2; j++) {
                    dp[i] += 2 * dp[j] * dp[i-j-1];
                }
                dp[i] += dp[i/2] * dp[i/2];
            }
        }
        return dp[n];
    }
}
