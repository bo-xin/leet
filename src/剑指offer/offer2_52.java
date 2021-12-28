package 剑指offer;

/**
 * @program: leet
 * @description: 展平二叉搜索树
 * @author: Tb
 * @create: 2021-12-08 09:57
 **/
public class offer2_52 {
    TreeNode newRoot;
    TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        newRoot = new TreeNode(-1);
        temp = newRoot;
        dfs(root);
        return newRoot.right;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        temp.right = root;
        root.left = null;
        temp = temp.right;
        dfs(root.right);
    }
}
