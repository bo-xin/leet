package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leet
 * @description: 含有重复元素集合的组合
 * @author: Tb
 * @create: 2021-12-20 10:07
 **/
public class offer2_82 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        boolean[] isVisited = new boolean[n];
        dfs(candidates,target,isVisited,0);
        return ans;
    }
    public void dfs(int[] candidates,int target,boolean[] isVisited,int idx){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if(isVisited[i]) continue;
            if(candidates[idx] > target) break;
            if(i > 0 && candidates[i] == candidates[i-1] && !isVisited[i-1]) continue;
            isVisited[i] = true;
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],isVisited,i);
            path.remove(path.size()-1);
            isVisited[i] = false;
        }
    }
}
