package 贪心策略;

import java.util.Arrays;

public class leet453 {
    public int minMoves(int[] nums) {
        /*求原数组和*/
        int sum = Arrays.stream(nums).sum();
        /*原数组长度*/
        int n = nums.length;
        /*原数组最小值*/
        int min = Arrays.stream(nums).min().getAsInt();
        /*答案*/
        return sum - n * min;
    }
}
