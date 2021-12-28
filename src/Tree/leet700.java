package Tree;

/**
 * @program: leet
 * @description: 二叉搜索树中的搜索
 * @author: Tb
 * @create: 2021-11-26 14:23
 **/
public class leet700 {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null){
            if(root.val == val) return root;
            else if(root.val > val) root = root.left;
            else root = root.right;
        }
        return root;
    }
}
