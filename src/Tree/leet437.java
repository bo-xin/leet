package Tree;

public class leet437 {
    // 返回该树上的所有情况
    public int pathSum(TreeNode root, int targetSum) {
        // 根为空直接返回
        if(root == null) return 0;
        // 先记录以根节点为起点的所有路径总数+遍历左子树节点为起点的情况+遍历右子树为起点的情况
        int res = getPath(root,targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
        return res;
    }
    // 统计以某个节点为起点的所有路径总数
    public int getPath(TreeNode root,int sum){
        if(root == null) return 0;
        int res = 0;
        if(root.val == sum) res++;
        res += getPath(root.right,sum-root.val) + getPath(root.left, sum - root.val);
        return res;
    }
}
