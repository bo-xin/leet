package 查找;

import java.util.PriorityQueue;

/**
 * @program: leet
 * @description: 第 K 个最小的素数分数
 * @author: Tb
 * @create: 2021-11-29 09:48
 **/
public class leet786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            double i1 = arr[a[0]] * 1.0 / arr[a[1]], i2 = arr[b[0]] * 1.0 / arr[b[1]];
            return Double.compare(i1, i2);
        });
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{0,i});
        }
        while (k-- > 1){
            int[] poll = q.poll();
            int i = poll[0], j = poll[1];
            if(i+1<j) q.add(new int[]{i+1,j});
        }
        int[] poll = q.poll();
        return new int[]{arr[poll[0]],arr[poll[1]]};
    }
}
