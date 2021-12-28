package 剑指offer;

/**
 * @program: leet
 * @description: 查找插入位置
 * @author: Tb
 * @create: 2021-12-14 09:53
 **/
public class offer2_68 {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (r - l)/2 + l+1;
            if(nums[mid] > target){
                r = mid-1;
            }else {
                l = mid;
            }
        }
        return nums[l] == target ? l : l + 1;
    }
}
