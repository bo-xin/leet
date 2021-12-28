package Tree;

public class leet1373 {
    int maxSum = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        travel(root);
        return maxSum < 0 ? 0 : maxSum;
    }
    public int[] travel(TreeNode root){
        if(root == null){
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int[] left = travel(root.left);
        int[] right = travel(root.right);
        int[] res = new int[4];
        if(left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            res[0] = 1;
            res[1] = Math.min(root.val,left[1]);
            res[2] = Math.max(root.val,right[2]);
            res[3] = root.val + left[3] + right[3];
            maxSum = Math.max(maxSum,res[3]);
        }else {
            res[0] = 0;
        }
        return res;
    }

}
