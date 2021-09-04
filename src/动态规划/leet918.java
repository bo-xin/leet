package 动态规划;

import java.util.Map;

public class leet918 {
    public static void main(String[] args) {
        System.out.println(new leet918().maxSubarraySumCircular(new int[]{1,5,-5,-8,45}));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0],minSum = nums[0],pre1 = 0,pre2 = 0, arrSum = 0;
        for (int num : nums){
            arrSum += num;
            pre1 = Math.max(pre1+num,num);
            maxSum = Math.max(maxSum,pre1);
            pre2 = Math.min(pre2+ num,num);
            minSum = Math.min(minSum,pre2);
        }
        System.out.println(minSum);
        System.out.println(maxSum);
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum,arrSum - minSum);
    }
}
