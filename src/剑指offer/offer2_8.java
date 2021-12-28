package 剑指offer;

public class offer2_8 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0,right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (right < n){
            sum += nums[right];
            while (left <= right && sum >= target){
                ans = Math.min(ans,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
