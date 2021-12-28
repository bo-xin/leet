package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
* 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
* 两棵树重复是指它们具有相同的结构以及相同的结点值。
* */
public class leet652 {
    List<TreeNode> ans = new LinkedList<>();
    Map<String,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travel(root);
        return ans;
    }
    public String travel(TreeNode root){
        if(root == null) return "#";
        String left = travel(root.left);
        String right = travel(root.right);
        String  subTree = left+","+right+","+root.val;
        int freq = map.getOrDefault(subTree,0);
        if(freq == 1){
            ans.add(root);
        }
        map.put(subTree,freq+1);
        return subTree;
    }
}
