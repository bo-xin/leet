package 剑指offer;

import java.util.Arrays;

/**
 * @program: leet
 * @description: 环形房屋偷盗
 * @author: Tb
 * @create: 2021-12-21 10:05
 **/
public class offer2_90 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length < 3) return Arrays.stream(nums).max().getAsInt();
        int num1 = robNum(nums,0,n-1);
        int num2 = robNum(nums,1,n);
        return Math.max(num1,num2);
    }
    public int robNum(int[] nums,int start,int end){
        int n = nums.length;
        int[] dp = new int[end-start];
        if(end - start < 2)return nums[start];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i < end; i++) {
            dp[i-start] = Math.max(dp[i-start-1],dp[i-start-2]+nums[i]);
        }
        return dp[end-start-1];
    }
}
