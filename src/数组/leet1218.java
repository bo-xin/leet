package 数组;

import java.util.HashMap;
import java.util.Map;

/*
* 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，
* 该子序列中相邻元素之间的差等于 difference 。
* 子序列 是指在不改变其余元素顺序的情况下，
* 通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
* */
public class leet1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        /*记录最大长度*/
        int ans = Integer.MIN_VALUE;
        /*记录以当前数结尾的数组长度*/
        Map<Integer,Integer> map = new HashMap<>();
        for (int val : arr) {
            /*把以当前述结尾的长度，放入map中*/
            map.put(val,map.getOrDefault(val-difference,0)+1);
            /*更新一下返回值*/
            ans = Math.max(ans,map.get(val));
        }
        return ans;
    }
}
