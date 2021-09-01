package 题解;
/*
有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。

对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。

并返回一个包含给定查询 queries 所有结果的数组。

 */
import java.util.Arrays;

public class leet1310 {
    public int[] xorQueries(int[]arr,int[][] queries){
        int n = queries.length;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int xor = 0;
            for(int j=l;j<=r;j++){
                xor ^= arr[j];
            }
            ans[i] = xor;
        }
        return ans;
    }
    public int[] xorQueries1(int[] arr,int[][] queries){
        int len = arr.length;
        int[] preSum = new int[len+1];
        preSum[0] = arr[0];
        for(int i = 0;i<len;i++){
            preSum[i+1] = preSum[i]^arr[i];
        }
        int n = queries.length;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            int l = queries[i][0];
            int r = queries[i][1]+1;
            ans[i] = preSum[l]^preSum[r];
        }
        return ans;
    }
}
