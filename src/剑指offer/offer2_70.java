package 剑指offer;

/**
 * @program: leet
 * @description: 排序数组中只出现一次的数字
 * @author: Tb
 * @create: 2021-12-14 10:30
 **/
public class offer2_70 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r){
            int mid = (l + r + 1)>>1;
            if(nums[mid] == nums[mid-1]){
                if((mid - l + 1)%2 == 0){
                    l = mid + 1;
                }else {
                    r = mid;
                }
            }else {
                if((mid - l) % 2 == 0){
                    l = mid;
                }else {
                    r = mid -1;
                }
            }
        }
        return nums[l];
    }
}
