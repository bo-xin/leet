package 周赛;
/*
给你两个整数数组 nums1 和 nums2 ，它们长度都为 n 。

两个数组的 异或值之和 为 (nums1[0] XOR nums2[0]) + (nums1[1] XOR nums2[1]) + ... + (nums1[n - 1] XOR nums2[n - 1]) （下标从 0 开始）。

比方说，[1,2,3] 和 [3,2,1] 的 异或值之和 等于 (1 XOR 3) + (2 XOR 2) + (3 XOR 1) = 2 + 0 + 2 = 4 。
请[72,97,8,32,15]
[63,97,57,60,83]你将 nums2 中的元素重新排列，使得 异或值之和 最小 。
[100,26,12,62,3,49,55,77,97]
[98,0,89,57,34,92,29,75,13]
请你返回重新排列之后的 异或值之和 。
 */
public class leet5756 {
    public static void main(String[] args) {
        int[] nums1 = {100,26,12,62,3,49,55,77,97};
        int[] nums2 = {98,0,89,57,34,92,29,75,13};
        System.out.println(new leet5756().minimumXORSum(nums1,nums2));
    }
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                dp[i][j] = nums1[i]^nums2[j];
            }
        }
        int res = 0;
        for (int i = 0; i <n ; i++) {
            int[] temp = new int[3];
            temp = findMin(dp);
            res+=temp[2];
            setMartix(dp,temp[0],temp[1]);
            System.out.println(temp[2]);
        }
        return res;
    }
    public void setMartix(int[][] nums,int i,int j){
        for (int k = 0; k < nums.length; k++) {
            nums[i][k] = -1;
        }
        for (int k = 0; k <nums[0].length ; k++) {
            nums[k][j] = -1;
        }
    }
    private int[] findMin(int[][] nums){
        int[] res =new int[3];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums[0].length ; j++) {
                if(nums[i][j]==-1){
                    continue;
                }else {
                    if(nums[i][j] < min){
                        min = nums[i][j];
                        res[0] = i;
                        res[1] = j;
                        res[2] = nums[i][j];
                    }
                }

            }
        }
        return res;
    }
}
