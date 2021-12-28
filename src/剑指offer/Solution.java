package 剑指offer;

import java.util.Random;

/**
 * @program: leet
 * @description: 按权生成随机数
 * @author: Tb
 * @create: 2021-12-15 10:12
 **/
public class Solution {
    int[] pre;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        int n = w.length;
        pre = new int[n];
        pre[0] = w[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int n = pre.length;
        System.out.println(n);
        int target = random.nextInt(pre[n-1]);
        int l = 0, r = n-1;
        while (l < r){
            int mid = (l + r) >> 1;
            if(pre[mid] > target) r = mid;
            else l = mid+1;
        }
        return l;
    }
}
