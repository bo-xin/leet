package 动态规划;

public class leet55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = nums[0];
        for (int i = 0; i < n-1; i++) {
            if(i <= rightMost){
                rightMost = Math.max(rightMost,i+nums[i]);
            }
            if(rightMost >= n-1){
                return true;
            }
        }
        return false;
    }
}
