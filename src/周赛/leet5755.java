package 周赛;

import java.util.Arrays;

public class leet5755 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j =nums.length-1;
        int res = Integer.MAX_VALUE;
        while (i<j){
            res = Math.min(res,nums[i]+nums[j]);
            i++;
            j--;
        }
        return res;
    }
}
