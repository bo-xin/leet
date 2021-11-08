package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class offer57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(target-num)) return new int[]{num,target-num};
            set.add(num);
        }
        return new int[2];
    }
}
