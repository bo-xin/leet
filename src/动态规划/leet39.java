package 动态规划;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leet39 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        res = new ArrayList<>();
        backTrace(candidates, target,0,new LinkedList<>(),n);
        return res;
    }
    public void backTrace(int[] candidates, int target, int index, List<Integer> list,int len){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < len; i++) {
            list.add(candidates[i]);
            backTrace(candidates,target - candidates[i], i,list,len);
            list.remove(list.size()-1);
        }
    }
}
