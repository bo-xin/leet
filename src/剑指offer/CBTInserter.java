package 剑指offer;

import java.util.LinkedList;

/**
 * @program: leet
 * @description: 往完全二叉树添加节点
 * @author: Tb
 * @create: 2021-12-06 10:36
 **/
public class CBTInserter {
    TreeNode root;
    LinkedList<TreeNode> queue;
    public CBTInserter(TreeNode root) {
        queue = new LinkedList<>();
        this.root = root;
        queue.addLast(root);
        while (queue.peek().left != null || queue.peek().right!=null){
            TreeNode temp = queue.peekFirst();
            if(temp.right != null){
                queue.pollFirst();
                queue.addLast(temp.left);
                queue.addLast(temp.right);
            }else {
                queue.addLast(temp.left);
                break;
            }
        }
    }

    public int insert(int v) {
        if(queue.isEmpty()) return 0;
        TreeNode father = queue.peekFirst();
        TreeNode temp = new TreeNode(v);
        if(father.left == null){
            father.left = temp;
            queue.addLast(father.left);
        }else if(father.left != null && father.right == null){
            father.right = temp;
            queue.addLast(father.right);
            queue.pollFirst();
        }

        return father.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
