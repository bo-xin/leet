package 剑指offer;

import java.util.Stack;

/**
 * @program: leet
 * @description: 每日温度
 * @author: Tb
 * @create: 2021-12-03 11:27
 **/
public class leet2_38 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ){
                int temp = stack.pop();
                ans[temp] = i-temp;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
