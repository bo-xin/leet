package 动态规划;

import java.io.File;

public class leet343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax,Math.max((i-j)*j,j*dp[i-j]));
            }
            dp[i] = curMax;
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
