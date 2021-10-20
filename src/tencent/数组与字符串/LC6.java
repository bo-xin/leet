package tencent.数组与字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC6 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(new LC6().threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            if(i>0 && nums[i-1]==nums[i]) continue;
            int left = i+1, right = n-1;
            while (left<right){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                if(nums[left] + nums[right] > 0-nums[i]){
                    right--;
                }else if(nums[left] + nums[right] < 0-nums[i]){
                    left++;
                }else {
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (left < right && nums[left+1] == nums[left]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
