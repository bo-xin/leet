package 动态规划;
/*
集团里有 n 名员工，他们可以完成各种各样的工作创造利润。

第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。

工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。

有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。

 */
public class leet879 {
    int mod = (int) 1e9+7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int gl = group.length;
        int pl = profit.length;
        int[][][] dp = new int[pl+1][n+1][minProfit+1];
        for(int i = 0;i<=n;i++) dp[0][i][0] = 1;
        for (int i = 1; i <=pl ; i++) {
            int a = group[i-1], b = profit[i-1];
            for (int j = 0; j <=n ; j++) {
                for (int k = 0; k <=minProfit ; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if(j>=a){
                        int u = Math.max(0,k-b);
                        dp[i][j][k] += dp[i-1][j-a][u];
                        dp[i][j][k] %= mod;
                    }
                }
            }
        }
        return (int)dp[pl][n][minProfit];
    }
    public int profitableSchemes1(int n, int minProfit, int[] group, int[] profit) {
        int pl = profit.length;
        int[][] dp = new int[n+1][minProfit+1];
        for(int i = 0;i<=n;i++) dp[i][0] = 1;
        for (int i = 1; i <=pl ; i++) {
            int a = group[i-1], b = profit[i-1];
            for(int j = n;j>=a;j--){
                for (int k = minProfit; k >0 ; k--) {
                    int u = Math.max(0,k-b);
                    dp[j][k] +=dp[j-a][u];
                    dp[j][k]%=mod;
                }
            }
        }
        return (int)dp[n][minProfit];
    }
}
