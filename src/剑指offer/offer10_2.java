package 剑指offer;

public class offer10_2 {
    int MOD = 1000000007;
    public int numWays(int n) {
        int[] dp = new int[n+1];
        if(n == 0 || n==1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1]+dp[i-2]) % MOD;
        }
        return dp[n];
    }
}
