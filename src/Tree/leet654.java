package Tree;

public class leet654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }
    public TreeNode construct(int[] nums,int left,int right){
        if(left > right) return null;
        int index = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if(maxValue < nums[i]){
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = construct(nums,left,index-1);
        root.right = construct(nums,index+1,right);
        return root;
    }
}
