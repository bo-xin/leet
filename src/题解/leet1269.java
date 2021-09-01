package 题解;
/*
有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。

 */
public class leet1269 {
    public int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;
        //走的太远，无法返回，找到最大的column值
        int maxColumn = Math.min(steps/2+1,arrLen-1);
        int[][] dp = new int[steps+1][maxColumn+1];
        //初始化边界条件
        dp[0][0] = 1;
        //行走步数
        for(int i = 1;i<=steps;i++){
            //当前位置
            for(int j=0;j<=maxColumn;j++){
                dp[i][j] = dp[i-1][j];
                if(j-1>=0){
                    dp[i][j] = (dp[i][j]+dp[i-1][j-1])%MODULO;
                }
                if(j+1<=maxColumn){
                    dp[i][j] = (dp[i][j]+dp[i-1][j+1])%MODULO;
                }
            }
        }
        return dp[steps][0];
    }
    public int numWays1(int steps, int arrLen){
        final int MODULO = 1000000007;
        int maxColumn = Math.min(steps/2+1,arrLen-1);
        int[] dp = new int[maxColumn+1];
        dp[0] =1;
        for(int i  = 1;i<=steps;i++){
            int[] next = new int[maxColumn+1];
            //通过上一步结果，得到新一步结果
            for(int j =0;j<=maxColumn;j++){
                next[j] = dp[j];
                if(j-1>=0){
                    next[j] = (next[j]+dp[j-1])%MODULO;
                }
                if(j+1<=maxColumn){
                    next[j] = (next[j]+dp[j+1])%MODULO;
                }
            }
            //新一步结果赋值到上一步结果中
            dp=next;
        }
        return dp[0];
    }
}
