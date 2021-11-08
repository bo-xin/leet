package 剑指offer;

public class offer55_1 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft,maxRight)+1;
    }
}
