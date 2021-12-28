package 剑指offer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 二叉搜索树中的中序后继
 * @author: Tb
 * @create: 2021-12-09 10:57
 **/
public class offer2_53 {
    List<TreeNode> list = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traver(root);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if(i == size-1 && list.get(i).val == p.val) return null;
            if(list.get(i).val == p.val) return list.get(i+1);
        }
        return null;
    }
    public void traver(TreeNode root){
        if(root == null) return;
        traver(root.left);
        list.add(root);
        traver(root.right);
    }
}
