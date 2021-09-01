package 动态规划;
/*
亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。

亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。

假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 */
public class leet877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <=n ; i++) {
            for (int l = 1; l+i-1 <= n ; l++) {
                int r = l+i-1;
                int a = piles[l] - dp[l+1][r];
                int b = piles[r] - dp[l][r-1];
                dp[l][r] = Math.max(a,b);
            }
        }
        return dp[1][n]>0;
    }
}
