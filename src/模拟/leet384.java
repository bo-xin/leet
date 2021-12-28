package 模拟;

import java.util.Arrays;
import java.util.Random;

public class leet384 {
    int[] nums;
    int n;
    Random random = new Random();
    public leet384(int[] nums) {
        this.nums = nums;
        n = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(nums,i,i+ random.nextInt(n-i));
        }
        return ans;
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
