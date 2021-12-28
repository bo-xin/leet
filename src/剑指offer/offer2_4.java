package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class offer2_4 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) ans = entry.getKey();
        }
        return ans;
    }

    public int singleNumber1(int[] nums){
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            if(total%3 != 0){
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
