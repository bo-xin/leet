package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[n];
        backtrace(nums, isVisited);
        return res;
    }
    public void backtrace(int[] nums, boolean[] isVisited){
        if(nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i] && !isVisited[i-1]) continue;
            if(isVisited[i]) continue;
            isVisited[i] = true;
            path.add(nums[i]);
            backtrace(nums, isVisited);
            path.remove(path.size()-1);
            isVisited[i] = false;
        }
    }
}
