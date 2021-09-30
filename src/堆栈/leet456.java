package 堆栈;

import java.util.Scanner;
import java.util.Stack;

public class leet456 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,3,2,0};
        System.out.println(find132pattern(nums));
    }
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int k = Integer.MIN_VALUE;
        for (int i = n-1; i >=0 ; i--) {
             if(nums[i] < k) return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]){
                k = Math.max(k,stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
