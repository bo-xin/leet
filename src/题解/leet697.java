package 题解;

import java.util.HashMap;
import java.util.Map;

/*
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 */
public class leet697 {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3,1};
        System.out.println(new leet697().findShortestSubArray(arr));
    }
    public int findShortestSubArray(int[] nums) {
        int res = Integer.MAX_VALUE;
        Map<Integer,Integer> countNum = new HashMap<>();
        Map<Integer,Integer> firstNum = new HashMap<>();
        Map<Integer,Integer> lastNum = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            countNum.put(nums[i],countNum.getOrDefault(nums[i],0)+1);
            if(!firstNum.containsKey(nums[i])){
                firstNum.put(nums[i],i);
                lastNum.put(nums[i],i);
            }else {
                lastNum.put(nums[i],i);
            }
        }
        int maxNUm = Integer.MIN_VALUE;
        for(int key:countNum.keySet()){
            if(countNum.get(key) > maxNUm){

                maxNUm = countNum.get(key);
            }
        }
        for(int key:countNum.keySet()){
            if(countNum.get(key) == maxNUm){
                res = Math.min(res,lastNum.get(key)-firstNum.get(key)+1);
            }

        }
        return res;
    }
}
