package 题解;

import java.util.Arrays;
import java.util.Stack;

public class leet503 {
    public int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<2*n-1;i++){
            int num = nums[i%n];
            while (!stack.isEmpty() && nums[stack.peek()] <num){
                res[stack.pop()] = num;
            }
            if(i<n){
                stack.push(i);
            }
        }
        return res;
    }
}
