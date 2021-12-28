package 剑指offer;

public class offer2_9 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int total = (n+1)*n/2;
        int l = 0,r = 0;
        int multi = 1;
        int num = 0;
        while (r < n){
            multi *= nums[r];
            while (l <= r && multi >= k){
                num+=(n-r);
                multi /= nums[l];
                l++;
            }
            r++;
        }
        return total-num;
    }
}
