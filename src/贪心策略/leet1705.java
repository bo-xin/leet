package 贪心策略;

import java.util.PriorityQueue;

/**
 * @program: leet
 * @description: 吃苹果的最大数目
 * @author: Tb
 * @create: 2021-12-24 09:52
 **/
public class leet1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = apples.length,time = 0,ans = 0;
        while (time < n || !pq.isEmpty()){
            if(time < n && apples[time] > 0) pq.add(new int[]{time+days[time]-1,apples[time]});
            while (!pq.isEmpty() && pq.peek()[0] < time) pq.poll();
            if(!pq.isEmpty()){
                int[] cur = pq.poll();
                if(cur[0] > time && --cur[1] > 0) pq.add(cur);
                ans++;
            }
            time++;
        }
        return ans;
    }
}
