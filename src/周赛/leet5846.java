package 周赛;

public class leet5846 {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i-1] + nums[i];
        }
        if(nums[n-1] - nums[0] == 0) return 0;
        for (int i = 1; i < n-1; i++) {
            if(nums[i-1] == (nums[n-1] - nums[i])) return i;
        }
        if(nums[n-2] == 0) return n-1;
        return -1;
    }
}
