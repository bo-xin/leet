package 剑指offer;

/**
 * @program: leet
 * @description: 剑指 Offer II 012. 左右两边子数组的和相等
 * @author: Tb
 * @create: 2021-11-25 10:18
 **/
public class offer2_12 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1]+nums[i-1];
            System.out.println(sum[i]);
        }
        for (int i = 1; i < n; i++) {
            if(sum[n-1]-sum[i] == sum[i]-nums[i]) return i;
        }
        return -1;
    }
}
