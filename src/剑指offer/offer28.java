package 剑指offer;

public class offer28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode A, TreeNode B){
        if(A == null && B == null) return true;
        if(A == null || B == null || A.val != B.val) return false;
        return recur(A.left,B.right) && recur(A.right,B.left);
    }
}
