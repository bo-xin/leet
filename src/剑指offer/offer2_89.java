package 剑指offer;

/**
 * @program: leet
 * @description: 房屋偷盗
 * @author: Tb
 * @create: 2021-12-21 10:00
 **/
public class offer2_89 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n < 2)return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
