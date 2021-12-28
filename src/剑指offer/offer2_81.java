package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 允许重复选择的集合
 * @author: Tb
 * @create: 2021-12-18 13:58
 **/
public class offer2_81 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subAns = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traceBack(candidates,target,0,0);
        return ans;
    }
    public void traceBack(int[] candidates,int target,int sum,int idx){
        if(idx == candidates.length) return;
        if(sum == target){
            ans.add(new ArrayList<>(subAns));
            return;
        }
        traceBack(candidates,target,sum,idx+1);
        if(sum + candidates[idx] <= target){
            sum += candidates[idx];
            subAns.add(candidates[idx]);
            traceBack(candidates,target,sum,idx);
            sum -= subAns.remove(subAns.size()-1);
        }
    }
    public void dfs(int[] candidates,int target,int idx){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(subAns));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            subAns.add(candidates[i]);
            dfs(candidates,target-candidates[i],i);
            subAns.remove(subAns.size()-1);
        }
    }
}
