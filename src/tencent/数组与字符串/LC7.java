package tencent.数组与字符串;

import java.util.Arrays;

public class LC7 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(new LC7().threeSumClosest(nums,1));
    }
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = 10000000;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = n-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if(sum > target){
                    while (left < right && nums[right-1] == nums[right]) right--;
                    right--;
                }else {
                    while (left < right && nums[left] == nums[left+1]) left++;
                    left++;
                }
            }
        }
        return ans;
    }
}
