package 剑指offer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: leet
 * @description: 二叉搜索树迭代器
 * @author: Tb
 * @create: 2021-12-09 11:28
 **/
public class BSTIterator {
    List<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        traver(root);
    }

    public void traver(TreeNode root){
        if(root == null) return;
        traver(root.left);
        list.add(root.val);
        traver(root.right);
    }

    public int next() {
        int ans = list.get(index);
        index++;
        return ans;
    }

    public boolean hasNext() {
        int size = list.size();
        return index < size;
    }
}
