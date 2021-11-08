package 剑指offer;

import java.util.Arrays;

public class leet61 {
    public boolean isStraight(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < n-1; i++) {
            if(nums[i] == 0) joker++;
            else if (nums[i] == nums[i+1]) return false;
        }
        return nums[n-1] - nums[joker] < 5;
    }
}
