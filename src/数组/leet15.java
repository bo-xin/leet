package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) return res;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = n-1;
            while (l < r){
                int temp = nums[i] + nums[l] + nums[r];
                if(temp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(new ArrayList<>(list));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if(temp > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
}
