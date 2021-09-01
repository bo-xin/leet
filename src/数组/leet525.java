package 数组;

import java.util.HashMap;
import java.util.Map;

/*
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 */
public class leet525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        //把数组中0变为-1
        for (int i = 0; i < n; i++) {
            if(nums[i]==0) nums[i] = -1;
        }
        int res = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //初始化map,防止只出现一次0的情况，例如[0,1]或者[1,0]
        map.put(0,-1);
        for (int i = 0; i <n ; i++) {
            sum += nums[i];
            //判断是否已经有该前缀和，若有则返回长度
            if(map.containsKey(sum)){
                //求最大值
                res= Math.max(res,i-map.get(sum));
            }else {
                //放入sum,i
                map.put(sum,i);
            }
        }
        return res;
    }
}
