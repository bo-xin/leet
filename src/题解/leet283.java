package 题解;
/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class leet283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int j = 0;j<n;j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        for (int j = i;j<n;j++){
            nums[j] = 0;
        }
    }
}
