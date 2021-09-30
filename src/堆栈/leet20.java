package 堆栈;

import java.util.Scanner;
import java.util.Stack;

public class leet20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()){
            String string = scanner.next();
            System.out.println(isValid(string));
        }
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c=='{'){
                stack.push(c);
            }else if(c == ')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == ']'){
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
