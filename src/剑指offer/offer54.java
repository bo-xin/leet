package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class offer54 {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        return list.get(k);
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
