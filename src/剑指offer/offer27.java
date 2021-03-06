package 剑指offer;

public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null) mirrorTree(root.left);
        if(root.right != null) mirrorTree(root.right);
        return root;
    }
}
