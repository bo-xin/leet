package 题解;

import java.util.HashMap;

public class leet594 {
    public int findHS(int[] nums){
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int longest = 0;
        for(int key:map.keySet()){
            if(map.containsKey(key+1)){
                longest = Math.max(longest,map.get(key+1)+map.get(key));
            }
        }
        return longest;
    }
    public int findHS1(int[] nums){
        int res = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int cur = 0;
            boolean isTrue = false;
            for(int j = 0;j<n;j++){
                if(nums[i] == nums[j]){
                    cur++;
                }
                if(nums[i]+1 == nums[j]){
                    cur++;
                    isTrue = true;
                }
            }
            if(isTrue){
                res=Math.max(res,cur);
            }

        }
        return res;
    }

}
