package 剑指offer;

public class offer2_3 {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int bit = 0;
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if((i & (i-1))== 0){
                bit = i;
            }
            dp[i] = dp[i-bit]+1;
        }
        return dp;
    }
}
