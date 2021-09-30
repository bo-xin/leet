package 动态规划;

import java.util.Arrays;

/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class leet416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum %2 == 1){
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if(j >= nums[i]){
                    dp[j] |=dp[j-nums[i]];
                }
            }
        }
        return dp[n];
    }
}
