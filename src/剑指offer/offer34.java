package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class offer34 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target,new ArrayList<>());
        return res;
    }
    public void dfs(TreeNode root,int target,List<Integer> path){
        if(root == null) return;
        path.add(root.val);
        target -= root.val;
        if(root.left == null && root.right == null && target == 0){
            res.add(new ArrayList<>(path));
        }
        dfs(root.left,target,path);
        dfs(root.right,target,path);
        path.remove(path.size()-1);
    }
}
