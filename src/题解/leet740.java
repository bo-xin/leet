package 题解;

public class leet740 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,2,2,2,3,3,3,4};
        System.out.println(new leet740().deleteAndEarn(nums));
    }
    public int deleteAndEarn(int[] nums){
        int maxValue = Integer.MIN_VALUE;
        for(int num:nums){
            maxValue = Math.max(maxValue,num);
        }
        int[] scores = new int[maxValue+1];
        for(int i=0;i< nums.length;i++){
            scores[nums[i]] += nums[i];
        }
        return rob(scores);
    }
    public int rob(int[] scores){
        int[] dp = new int[scores.length];
        dp[0] = 0;
        dp[1] = scores[1];
        for(int i = 2;i<scores.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+scores[i]);
        }
        return dp[scores.length-1];
    }

}
