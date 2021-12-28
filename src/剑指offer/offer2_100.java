package 剑指offer;

import java.util.List;

/**
 * @program: leet
 * @description: 三角形中路径最小之和
 * @author: Tb
 * @create: 2021-12-26 18:11
 **/
public class offer2_100 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        System.out.println(dp[0][0]);
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0]+triangle.get(i-1).get(0);
            System.out.println(dp[i-1][0]+"  "+triangle.get(i-1).get(0));
            dp[i][i] = dp[i-1][i-1] + triangle.get(i-1).get(i-1);
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans,dp[m-1][i]);
        }
        return ans;
    }
}
