package 剑指offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leet
 * @description: 和为k的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * @author: Tb
 * @create: 2021-11-25 09:49
 **/
public class offer2_10 {
    @Test
    public void test(){
        int[] nums = {-1,-1,1};
        int k =0;
        System.out.println(subarraySum(nums, k));
    }
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
