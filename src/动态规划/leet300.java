package 动态规划;

public class leet300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        return dp[n];
    }
}
