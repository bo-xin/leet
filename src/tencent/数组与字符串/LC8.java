package tencent.数组与字符串;

import java.util.Stack;

public class LC8 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        stack.push(s.charAt(0));
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) =='(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    return false;
                }
            } else if(s.charAt(i) == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
