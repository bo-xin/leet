package Tree;

public class leet106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode construct(int[] post,int postLeft,int postRight,int[]in ,int inLeft,int inRight){
        if(postLeft > postRight || inLeft > inRight ) return null;
        int value = post[postRight];
        TreeNode root = new TreeNode(value);
        int index = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if(value == in[i]){
                index = i;
            }
        }
        int left_num = index - inLeft;
        root.left = construct(post,postLeft,postLeft+left_num-1,in,inLeft,index-1);
        root.right = construct(post,postLeft+left_num,postRight-1,in,index+1,inRight);
        return root;
    }
}
