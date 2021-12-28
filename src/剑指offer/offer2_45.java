package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leet
 * @description: 二叉树最底层最左边的值
 * @author: Tb
 * @create: 2021-12-06 18:41
 **/
public class offer2_45 {
    public int findBottomLeftValue(TreeNode root) {
         int ans = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if(i==0) ans = queue.peek().val;
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return ans;
    }
}
