package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leet216 {
    public static void main(String[] args) {
        System.out.println(new leet216().combinationSum3(3,7));
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] choose = {1,2,3,4,5,6,7,8,9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrace(k+1,n,0);
        return ans;
    }
    public void backtrace(int k,int n,int index){
        if(path.size() == k){
            if(n == 0){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i < choose.length; i++) {
            if(n < 0) continue;
            path.add(choose[i]);
            backtrace(k, n - choose[i],i+1);
            path.remove(path.size()-1);
        }
    }
}
