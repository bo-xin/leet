package 剑指offer;

import java.util.*;

/**
 * @program: leet
 * @description: 和最小的 k 个数对
 * @author: Tb
 * @create: 2021-12-12 16:56
 **/
public class offer2_61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
        pq.offer(new int[]{0,0});
        Set<String> set = new HashSet<>();
        while (k-- > 0 && pq.size() < k){
            int[] pair = pq.poll();
            System.out.println(pair[0]+"   "+pair[1]);
            ans.add(Arrays.asList(nums1[pair[0]],nums2[pair[1]]));
            if(pair[0]+1 < nums1.length){
                String key = String.valueOf(pair[0]+1)+"_"+String.valueOf(pair[1]);
                if(set.add(key)){
                    pq.offer(new int[]{pair[0]+1,pair[1]});
                }
            }
            if(pair[1]+1 < nums2.length){
                String key = String.valueOf(pair[0])+"_"+String.valueOf(pair[1]+1);
                if(set.add(key)){
                    pq.offer(new int[]{pair[0],pair[1]+1});
                }
            }
        }
        return ans;
    }
}
