package 题解;
/*
给定一个二进制数组， 计算其中最大连续 1 的个数。
 */
public class leet485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0,cur = 0;
        for(int num:nums){
            cur = num==0?0:cur+1;
            max = Math.max(cur,max);
        }
        return max;
    }
    public int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0,cur = 0;
        for(int num:nums){
            if(num == 1){
                cur ++;
            }else {
                max = Math.max(cur,max);
                cur = 0;
            }
        }
        max = Math.max(cur,max);
        return max;
    }
}
