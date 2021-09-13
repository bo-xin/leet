package 查找;

public class leet704 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) left += 1;
            else right +=1;
        }
        return -1;
    }
}
