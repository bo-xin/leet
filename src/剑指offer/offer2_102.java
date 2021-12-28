package 剑指offer;

/**
 * @program: leet
 * @description: 加减的目标值
 * @author: Tb
 * @create: 2021-12-27 17:35
 **/
public class offer2_102 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,target,0,0);
        return count;
    }
    public void dfs(int[] nums,int target,int sum,int index){
        if(index == nums.length){
            if(sum == target) count++;
        }else {
            dfs(nums,target,sum+nums[index],index+1);
            dfs(nums,target,sum-nums[index],index+1);
        }
    }


    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0)return 0;
        int neg = (sum - target)/2;
        int[][] dp = new int[n+1][neg+1];
        dp[0][0] =1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= num){
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[n][neg];
    }
}
