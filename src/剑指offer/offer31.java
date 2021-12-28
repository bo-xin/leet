package 剑指offer;

import java.util.Stack;

public class offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index =0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
