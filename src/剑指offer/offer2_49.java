package 剑指offer;

/**
 * @program: leet
 * @description: 从根节点到叶节点的路径数字之和
 * @author: Tb
 * @create: 2021-12-07 09:57
 **/
public class offer2_49 {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        sumNumber(root,new StringBuffer());
        return ans;
    }
    public void sumNumber(TreeNode root,StringBuffer sb){
        if(root == null) return;
        sb.append(root.val);
        if(root.left ==null && root.right == null){
            ans += Integer.valueOf(sb.toString());
        }
        sumNumber(root.left,sb);
        sumNumber(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
