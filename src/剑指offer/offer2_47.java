package 剑指offer;

/**
 * @program: leet
 * @description: 二叉树剪枝
 * @author: Tb
 * @create: 2021-12-07 09:49
 **/
public class offer2_47 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            root = null;
        }
        return root;
    }
}
