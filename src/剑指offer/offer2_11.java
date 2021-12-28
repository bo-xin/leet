package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet
 * @description: 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * @author: Tb
 * @create: 2021-11-25 10:14
 **/
public class offer2_11 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if(map.containsKey(sum)){
                ans = Math.max(ans,i-map.get(sum));
            }else {
                map.put(sum,i);
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
