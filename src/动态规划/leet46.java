package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class leet46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        boolean[] isVisited = new boolean[n];
        backTrace(nums, isVisited);
        return res;
    }
    public void backTrace(int[] nums,boolean[] isVisited){
        if(path.size() == nums.length){
            res.add(path);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            path.add(nums[i]);
            backTrace(nums, isVisited);
            path.remove(path.size()-1);
            isVisited[i] = false;
        }
    }

}
