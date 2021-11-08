package 剑指offer;

public class offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }
    public TreeNode build(int[] preorder,int preStart, int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        int val = inorder[inStart];
        TreeNode root = new TreeNode(val);
        int index = preStart;
        for (int i = preStart; i <= preEnd; i++) {
            if(preorder[i] == val){
                index=i;
                break;
            }
        }
        int len = index-preStart;
        root.left = build(preorder,preStart,index-1,inorder,inStart+1,inStart+len);
        root.right = build(preorder,index+1,preEnd,inorder,inStart+len+1,inEnd);
        return root;
    }
}
