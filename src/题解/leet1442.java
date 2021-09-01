package 题解;

import java.util.HashMap;
import java.util.Map;

/*
给你一个整数数组 arr 。
现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
a 和 b 定义如下：
a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
注意：^ 表示 按位异或 操作。
si = sk+1
请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 */
public class leet1442 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> cnt = new HashMap<>();
        Map<Integer,Integer> total = new HashMap<>();
        int ans = 0;
        int s = 0;
        for(int i = 0;i<n;i++){
            int val = arr[i];
            if(cnt.containsKey(s^val)){
                ans += cnt.get(s^val)*i-total.get(s^val);
            }
            //记录k之前出现次数
            cnt.put(s,cnt.getOrDefault(s,0)+1);
            //记录k之前出现次数的总和
            total.put(s,total.getOrDefault(s,0)+i);
            s^=val;
        }
        return ans;
    }
}
