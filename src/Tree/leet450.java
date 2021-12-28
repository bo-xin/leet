package Tree;

public class leet450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode minTreeNode = getMin(root.right);
            root.val = minTreeNode.val;
            root.right = deleteNode(root,minTreeNode.val);
        }
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
    public TreeNode getMin(TreeNode root){
        while (root.left != null) root = root.left;
        return root;
    }
}
