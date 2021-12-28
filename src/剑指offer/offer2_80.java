package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 含有k个元素的子集
 * @author: Tb
 * @create: 2021-12-18 13:52
 **/
public class offer2_80 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> subAns = new  ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(0,n,k);
        return ans;
    }
    public void dfs(int cur,int n, int k){
        if(subAns.size() == k){
            ans.add(new ArrayList<>(subAns));
            return;
        }
        if(cur == n || subAns.size() > k){
            return;
        }
        subAns.add(cur);
        dfs(cur+1,n,k);
        subAns.remove(subAns.size()-1);
        dfs(cur+1,n,k);
    }
}
