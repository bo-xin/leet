package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leet95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return build(1,n);
    }
    public List<TreeNode> build(int l,int r){
        List<TreeNode> res = new LinkedList<>();
        if(l > r){
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> lefts = build(l,i-1);
            List<TreeNode> rights = build(i+1,r);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
