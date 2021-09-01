package 数组;

import java.util.HashMap;
import java.util.Map;

/*
给定一个包含 非负数 的数组和一个目标 整数 k ，
编写一个函数来判断该数组是否含有连续的子数组，
其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。
 */
public class leet523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        //数组长度小于2，不存在子数组大小至少为2
        if(n<2) return false;
        //提高速度(对结果无影响)判断连续的两个0返回true
        for (int i = 0; i <n ; i++) {
            if(nums[i]==0 && nums[i+1]==0) return true;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        //防止以nums[0]开头的子数组成立
        map.put(0,-1);
        for (int i = 0; i <n ; i++) {
            sum +=nums[i];
            int mod = sum%k;
            if(map.containsKey(mod)){
                if(i-map.get(mod)>1) return true;
            }else {
                map.put(mod,i);
            }
        }
        return false;
    }
}
