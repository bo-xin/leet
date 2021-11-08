package 剑指offer;

import java.util.Arrays;
import java.util.Stack;


public class offer33 {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while (!stack.isEmpty() && postorder[i] < stack.peek()){
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

}
