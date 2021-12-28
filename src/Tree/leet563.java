package Tree;

public class leet563 {
    /*记录全部坡度*/
    int res = 0;
    public int findTilt(TreeNode root) {
        /*后序遍历*/
        dfs(root);
        return res;
    }
    /*递归函数返回root为根的所有节点和*/
    public int dfs(TreeNode root){
        if(root == null) return 0;
        /*返回左子树的和*/
        int left = dfs(root.left);
        /*返回右子树的和*/
        int right = dfs(root.right);
        /*记录root 的坡度*/
        res += Math.abs(left-right);
        /*返回root的和*/
        return root.val+left+right;
    }
}
