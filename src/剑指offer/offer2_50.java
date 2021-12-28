package 剑指offer;

/**
 * @program: leet
 * @description: 向下的路径节点之和
 * @author: Tb
 * @create: 2021-12-08 10:06
 **/
public class offer2_50 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return pathSumRoot(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    public int pathSumRoot(TreeNode root,int targetSum){
        int ret = 0;
        if(root == null) return 0;
        if(root.val == targetSum){
            ret++;
        }
        int target = targetSum - root.val;
        ret += pathSumRoot(root.left,target);
        ret += pathSumRoot(root.right,target);
        return ret;
    }
}
