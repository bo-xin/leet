package 题解;

import java.util.ArrayDeque;
import java.util.Queue;

public class leet993 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode( int val ){this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int dx = 0,dy = 0;
        TreeNode px = null,py = null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int h =0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            h++;
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    int val = node.left.val;
                    if(val == x){
                        dx = h+1;
                        px = node;
                    }else if(val == y){
                        dy = h+1;
                        py = node;
                    }
                    queue.offer(node.left);
                }
                if(node.right != null){
                    int val = node.right.val;
                    if(val == x){
                        dx = h+1;
                        px = node;
                    }else if(val == y){
                        dy = h+1;
                        py =node;
                    }
                    queue.offer(node.right);
                }
            }
        }
        return px != py && dx == dy;
    }
}
