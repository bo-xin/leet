package 动态规划;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet40 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length;
        boolean[] visited = new boolean[len];
        backTrace(candidates, target, 0,visited,len);
        return res;
    }
    public void backTrace(int[] candidates, int target, int index, boolean[] visited, int len){
        System.out.println(target);
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if(i > 0 && candidates[i-1] == candidates[i] && !visited[i-1]) continue;
            if(visited[i]) continue;
            visited[i] = true;
            path.add(candidates[i]);
            backTrace(candidates, target - candidates[i], i, visited,len);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
