package Tree;

public class leet114 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (left.right != null){
            left = left.right;
        }
        left.right = right;
    }
}
