package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer2_7 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if(n < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1,right = n-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (right > 0 && nums[right] == nums[right-1]) right--;
                    while (left < n-1 && nums[left] == nums[left+1]) left++;
                    right--;
                    left++;
                }else if(sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
