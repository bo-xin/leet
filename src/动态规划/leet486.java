package 动态规划;
/*
给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，
随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

 */
public class leet486 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        for (int len = 1;len <= n;len ++){
            for (int l = 1;l+len-1<=n;l++){
                int r = l+len-1;
                int a = nums[l-1] - dp[l+1][r];
                int b = nums[r-1] - dp[l][r-1];
                dp[l][r] = Math.max(a,b);
            }
        }
        return dp[0][n-1] >= 0;
    }

    public boolean PredictTheWinner1(int[] nums) {
        return total(nums, 0, nums.length - 1) >= 0;
    }
    public int total(int[] nums,int start,int end){
        if(start == end){
            return nums[start];
        }
        int startScore = nums[start]-total(nums,start+1,end);
        int endScore = nums[end]-total(nums,start,end-1);
        return Math.max(startScore,endScore);
    }



}
