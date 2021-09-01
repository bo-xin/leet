package 题解;

public class leet198 {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n+1];
        dp[1]=nums[0];
        dp[2] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i+1] = Math.max(dp[i],nums[i]+dp[i-1]);
        }
        return dp[n];
    }
}
