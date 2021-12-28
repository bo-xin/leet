package 剑指offer;

import java.util.Stack;

/**
 * @program: leet
 * @description: 后缀表达式
 * @author: Tb
 * @create: 2021-12-03 10:20
 **/
public class offer2_36 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (String s : tokens) {
            if(s.equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                ans = num1+num2;
                stack.push(ans);
            }else if(s.equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                ans = num2-num1;
                stack.push(ans);
            }else if(s.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                ans = num2/num1;
                stack.push(ans);
            }else if(s.equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                ans = num1*num2;
                stack.push(ans);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        if(!stack.isEmpty()) ans = stack.pop();
        return ans;
    }
}
