package 动态规划;

public class leet152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums,0,maxF,0,n);
        System.arraycopy(nums,0,minF,0,n);
        for (int i = 1; i < n; i++) {
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(nums[i],minF[i-1] * nums[i]));
            minF[i] = Math.min(minF[i-1] * nums[i], Math.min(nums[i], maxF[i-1]*nums[i]));
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,maxF[i]);
        }
        return ans;
    }
}
