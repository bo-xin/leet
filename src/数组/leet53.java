package 数组;

public class leet53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            ans = Math.max(pre,ans);
        }
        return ans;
    }
}
