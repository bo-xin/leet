package 周赛;

public class leet588 {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[j] > nums[i]){
                    ans = Math.max(ans,nums[j] - nums[i]);
                }
            }
        }
        return ans;
    }
}
