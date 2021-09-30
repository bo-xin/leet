package 贪心策略;

import java.util.Arrays;

public class leet517 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        // 求数组和
        int sum = Arrays.stream(machines).sum();
        // 不能平均就直接返回
        if(sum % n != 0) return -1;
        int ans = 0;
        // 求调整后的的大小
        int avg = sum / n;
        // 记录前面n个
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += machines[i];
            // 前面n个需要转移的数量和最大值到平均值的差值取最大
            ans = Math.max(ans,Math.max(Math.abs(preSum-(i+1)*avg),machines[i] - avg));
        }
        return ans;
    }
}
