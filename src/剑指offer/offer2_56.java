package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 二叉搜索树中两个节点之和
 * @author: Tb
 * @create: 2021-12-10 09:59
 **/
public class offer2_56 {
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        traver(root);
        if(list.size() < 2) return false;
        int l = 0, r= list.size()-1;
        while (l < r){
            int sum = list.get(l) + list.get(r);
            if(sum == k) return true;
            else if(sum < k) l++;
            else r--;
        }
        return false;
    }
    public void traver(TreeNode root){
        if(root == null) return;
        traver(root.left);
        list.add(root.val);
        traver(root.right);
    }
}
