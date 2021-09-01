package 题解;
/*
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

 */
public class leet287 {
    public int findDuplicate(int[] nums){
        int l = 1;
        int r = nums.length-1;
        while (l<=r){
           int cnt = 0;
           int mid = (l+r)/2;
           for(int i = 0;i<nums.length;i++){
               if(nums[i]<=mid) cnt ++;
           }
           if( cnt > mid) r=mid-1;
           else l = mid +1;
        }
        return l;
    }
}
