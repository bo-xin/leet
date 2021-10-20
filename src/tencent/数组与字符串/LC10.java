package tencent.数组与字符串;

public class LC10 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3,3,4,4,5,5};
        System.out.println(new LC10().removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int n = nums.length;
        for (int fast = 0; fast < n; fast++) {
            if(nums[fast] == nums[slow]) continue;
            else nums[++slow] = nums[fast];
        }
        return slow+1;
    }
}
