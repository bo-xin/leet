package 动态规划;

/**
 * @program: leet
 * @description: 三个无重叠子数组的最大和
 * @author: Tb
 * @create: 2021-12-08 09:45
 **/
public class leet689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        long[][] f = new long[n + 10][4];
        for (int i = n - k + 1; i >= 1; i--) {
            for (int j = 1; j < 4; j++) {
                f[i][j] = Math.max(f[i + 1][j], f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]);
            }
        }
        int[] ans = new int[3];
        int i = 1, j = 3, idx = 0;
        while (j > 0) {
            if (f[i + 1][j] > f[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]) {
                i++;
            } else {
                ans[idx++] = i - 1;
                i += k; j--;
            }
        }
        return ans;
    }
}
