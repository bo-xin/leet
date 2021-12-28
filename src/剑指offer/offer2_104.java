package 剑指offer;

/**
 * @program: leet
 * @description: 排列的数目
 * @author: Tb
 * @create: 2021-12-27 19:17
 **/
public class offer2_104 {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if(nums[j] <= i){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
