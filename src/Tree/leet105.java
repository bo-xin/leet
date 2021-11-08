package Tree;

public class leet105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode construct(int[] pre,int preLeft,int preRight,int[]in ,int inLeft,int inRight){
        if(preLeft > preRight || inLeft > inRight ) return null;
        int value = pre[preLeft];
        TreeNode root = new TreeNode(value);
        int index = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if(value == in[i]){
                index = i;
            }
        }
        int left_num = index - inLeft;
        root.left = construct(pre,preLeft+1,preLeft+left_num,in,inLeft,index-1);
        root.right = construct(pre,preLeft+left_num+1,preRight,in,index+1,inRight);
        return root;
    }
}
