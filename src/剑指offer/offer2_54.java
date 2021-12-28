package 剑指offer;

/**
 * @program: leet
 * @description: 所有大于等于节点的值之和
 * @author: Tb
 * @create: 2021-12-09 11:14
 **/
public class offer2_54 {
    int add = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            root.val += add;
            add = root.val;
            convertBST(root.left);
        }
        return root;
    }

}
