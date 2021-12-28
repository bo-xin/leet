package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leet
 * @description: 含有重复元素的全排列
 * @author: Tb
 * @create: 2021-12-20 10:25
 **/
public class offer2_84 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] isVisited = new boolean[n];
        traceBack(nums,isVisited);
        return ans;
    }
    public void traceBack(int[] nums,boolean[] isVisited){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !isVisited[i-1]) continue;
            isVisited[i] = true;
            path.add(nums[i]);
            traceBack(nums,isVisited);
            path.remove(path.size()-1);
            isVisited[i] = false;
        }
    }
}
