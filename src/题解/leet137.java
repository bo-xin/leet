package 题解;

import java.util.HashMap;

public class leet137 {
    public int singleNumber(int[] nums){
        int res = 0;
        int n = nums.length;
        if(n==1) return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num : map.keySet()){
            int temp = map.get(num);
            if(temp == 1){
                res =  num;
            }
        }
        return res;
    }
}
