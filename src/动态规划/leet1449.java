package 动态规划;

import java.util.Arrays;

/*
给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：

给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
总成本必须恰好等于 target 。
添加的数位中没有数字 0 。
由于答案可能会很大，请你以字符串形式返回。

输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
输出："7772"
解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要求的数字，但 "7772" 是较大的数字。
 数字     成本
  1  ->   4
  2  ->   3
  3  ->   2
  4  ->   5
  5  ->   6
  6  ->   7
  7  ->   2
  8  ->   5
  9  ->   5
 */
public class leet1449 {
    public String largestNumber(int[] cost, int target) {
        int n =cost.length;
        int[][] dp = new int[n+1][target+1];
        //记录取数值的数组
        int[][] from = new int[n+1][target+1];
        //初始化数组的值
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n ; i++) {
            int c = cost[i-1];
            for (int j = 0; j <=target ; j++) {
                //判断是否可以取i
                if (j<c){
                    dp[i][j] = dp[i-1][j];
                    from[i][j] = j;
                }else {
                    //可以取i，确定是否会取i
                    if(dp[i-1][j] > dp[i][j-c]+1){
                        dp[i][j] = dp[i-1][j];
                        from[i][j] = j;
                    }else {
                        dp[i][j] = dp[i][j-c]+1;
                        from[i][j] = j-c;
                    }
                }
            }
        }
        //若dp<0，则返回“0”
        if(dp[n][target] < 0){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        //设置ij的值
        int i = n,j=target;
        while (i>0){
            //若值为j则表示没有取i
            if(from[i][j] == j){
                i--;
            }else {
                //取i，j的值相对应减小
                sb.append(i);
                j = from[i][j];
            }
        }
        return sb.toString();
    }

    public String largestNumber1(int[] cost, int target) {
        int n = cost.length;
        int[] dp = new int[target+1];
        //初始化数组
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        for (int c :cost){
            for (int j = c; j <=target ; j++) {
                //判断是否会取值c
                dp[j] = Math.max(dp[j],dp[j-c]+1);
            }
        }
        //最大长度小于0，返回“0”
        if(dp[target] < 0){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        //从后向前取值，初始化j
        for(int i = n-1,j=target;i>=0 ;i--){
            //判断是够可以取cost[i],dp[j] == dp[j-c]+1判断是否选择cost[i]
            for(int c = cost[i] ;j>=c && dp[j] == dp[j-c]+1;j-=c){
                sb.append(i+1);
            }
        }
        return sb.toString();
    }
}
