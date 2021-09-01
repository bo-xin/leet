package 题解;



import java.util.ArrayList;
import java.util.List;

public class leet872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        list1 = dfs(root1,list1);
        List<Integer> list2 = new ArrayList<>();
        list2 = dfs(root2,list2);
        int len1 = list1.size();
        int len2 = list2.size();
        if(len1 != len2) return false;
        for(int i=0;i<len1;i++){
            if(list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }
    public List<Integer> dfs(TreeNode root,List<Integer> list){
        if(root == null) return list;
        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        dfs(root.left,list);
        dfs(root.right,list);
        return list;
    }
}
