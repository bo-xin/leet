package 剑指offer;

import org.junit.Test;

/**
 * @program: leet
 * @description: 子序列的数目
 * @author: Tb
 * @create: 2021-12-24 10:07
 **/
public class offer2_97 {
    @Test
    public void test(){
        System.out.println(numDistinct("babgbag", "bag"));
    }
    public int numDistinct(String s, String t) {
        int m = t.length(),n = s.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
