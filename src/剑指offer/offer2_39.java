package 剑指offer;

import java.util.Stack;

/**
 * @program: leet
 * @description: 直方图最大矩形面积
 * @author: Tb
 * @create: 2021-12-06 19:52
 **/
public class offer2_39 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek()-1;
                ans = Math.max(ans,height*width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            ans = Math.max(ans,width*height);
        }
        return ans;
    }
}
