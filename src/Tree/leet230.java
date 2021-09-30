package Tree;

public class leet230 {
    int res = 0;
    int  k_;
    public int kthSmallest(TreeNode root, int k) {
        this.k_ = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root == null)return;
        dfs(root.left);
        System.out.println(root.val);
        k_ -=1;
        if(k_ == 0){
            res = root.val;
            return;
        }
        dfs(root.right);
    }
}
