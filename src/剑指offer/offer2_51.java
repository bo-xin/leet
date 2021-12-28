package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: leet
 * @description: 节点之和最大的路径
 * @author: Tb
 * @create: 2021-12-08 10:20
 **/
public class offer2_51 {
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxOne(root);
        return ans;
    }
    public int maxOne(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,maxOne(root.left));
        int right = Math.max(0,maxOne(root.right));
        ans = Math.max(ans,root.val+left+right);
        return root.val+Math.max(left,right);
    }
}
