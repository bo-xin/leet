package 剑指offer;

public class offer21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        new offer21().exchange(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int left =0, right = n-1;
        while (left < right){
            while (left < right && nums[left] % 2 == 1) left++;
            while (left < right && nums[right] % 2 == 0) right--;
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
        }
        return nums;
    }
}
