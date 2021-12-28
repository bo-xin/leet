package 剑指offer;

import java.util.PriorityQueue;

/**
 * @program: leet
 * @description: 数据流的第 K 大数值
 * @author: Tb
 * @create: 2021-12-12 16:34
 **/
public class KthLargest {
    PriorityQueue<Integer> pq;
    int size;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > size){
            pq.poll();
        }
        return pq.peek();
    }
}
