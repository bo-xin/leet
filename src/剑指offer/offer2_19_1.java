package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 所有子集
 * @author: Tb
 * @create: 2021-12-18 13:48
 **/
public class offer2_19_1 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subAns = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return ans;
    }
    public void dfs(int cur ,int[] nums){
        if(cur == nums.length){
            ans.add(new ArrayList<>(subAns));
            return;
        }
        subAns.add(nums[cur]);
        dfs(cur+1,nums);
        subAns.remove(subAns.size()-1);
        dfs(cur+1,nums);
    }
}
