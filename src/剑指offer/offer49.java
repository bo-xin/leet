package 剑指offer;

public class offer49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int idx2 = 1, idx3 =1, idx5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[idx2]*2,Math.min(dp[idx3]*3,dp[idx5]*5));
            if(dp[idx2]*2 == dp[i]){
                idx2++;
            }
            if(dp[idx3] * 3 == dp[i]){
                idx3++;
            }
            if(dp[idx5]*5 == dp[i]){
                idx5++;
            }
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
