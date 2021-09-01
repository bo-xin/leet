package 题解;

import java.util.Arrays;
import java.util.HashSet;

public class leet217 {
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        return set.size() < nums.length;
    }
    public boolean containsDuplicate1(int[] nums){
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}
