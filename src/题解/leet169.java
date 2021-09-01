package 题解;

import java.util.Arrays;

/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素
 */
public class leet169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer res = null;
        for(int num:nums){
            if(count == 0){
                res = num;
            }
            count +=res==num ? 1:-1;
        }
        return res;
    }
    public int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
