package 剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: leet
 * @description: 出现频率最高的 k 个数字
 * @author: Tb
 * @create: 2021-12-12 16:41
 **/
public class offer2_60 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if(pq.size() == k){
                if(count > pq.peek()[1]){
                    pq.poll();
                    pq.offer(new int[]{num,count});
                }
            }else {
                pq.offer(new int[]{num,count});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
