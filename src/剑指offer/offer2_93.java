package 剑指offer;

/**
 * @program: leet
 * @description: 最长斐波那契数列
 * @author: Tb
 * @create: 2021-12-22 10:57
 **/
public class offer2_93 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 2; i < n; i++) {
            int j = 0,k = i-1;
            while (j < k){
                int sum = arr[j] + arr[k];
                if(sum == arr[i]){
                    if(dp[j][k] == 0){
                        dp[k][i] = 3;
                    }else {
                        dp[k][i] = dp[j][k]+1;
                    }
                    max = Math.max(dp[k][i],max);
                    j++;
                    k--;
                }else if(sum < arr[i]){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return max;
    }
}
