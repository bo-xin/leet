package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if(n < 4) return res;
        for (int i = 0; i < n-3; i++) {
            if(i > 0 && nums[i-1] == nums[i]) continue;
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target) break;
            if(nums[i] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue;
            for (int j = i+1; j < n-2; j++) {
                if(j > i +1 && nums[j] == nums[j-1]) continue;
                if(nums[j] + nums[j+1] + nums[j+2] + nums[i] > target) break;
                if(nums[i] + nums[j] + nums[n-1] + nums[n-2] < target) continue;
                int l = j+1, r= n-1;
                while (l < r){
                    int temp = nums[i] + nums[j] + nums[l] + nums[r];
                    if (temp == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(new ArrayList<>(list));
                        while (l <r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(temp > target){
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
