package 题解;
/*
给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。

它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。

 */
public class leet1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length+1;
        int[] perm = new int[n];
        int totalPre = 0;
        for(int i =1;i<=n;i++){
            totalPre ^=i;
        }
        int totalDecode = 0;
        for(int i=1;i<n-1;i+=2){
            totalDecode ^=encoded[i];
        }
        perm[0] = totalDecode^totalPre;
        for(int i=1;i<n;i++){
            perm[i] = encoded[i-1]^perm[i-1];
        }
        return perm;
    }
}
