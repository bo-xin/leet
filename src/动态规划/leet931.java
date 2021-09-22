package 动态规划;

public class leet931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0){
                    dp[i][j] = matrix[i][j];
                }else {
                    if(j==0){
                        dp[i][j] = Math.min(dp[i-1][j]+matrix[i][j],dp[i-1][j+1]+matrix[i][j]);
                    }else if(j==n-1){
                        dp[i][j] = Math.min(dp[i-1][j]+matrix[i][j],dp[i-1][j-1]+matrix[i][j]);
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j-1]+matrix[i][j],
                                Math.min(dp[i-1][j]+matrix[i][j],dp[i-1][j+1]+matrix[i][j]));
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[m-1][i],min);
        }
        return min;
    }
}
