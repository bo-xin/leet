package 字符串;

import java.util.Stack;

/*
给出一个字符串 s（仅含有小写英文字母和括号）。

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

注意，您的结果中 不应 包含任何括号。


输入：s = "(u(love)i)"
输出："iloveu"
 */
public class leet1190 {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if (ch == ')'){
                sb.reverse();
                sb.insert(0,stack.pop());
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String reverseParentheses1(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Stack<Integer>  stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        StringBuffer sb = new StringBuffer();
        int index = 0;int step = 1;
        while (index < n){
            if(s.charAt(index) == '(' || s.charAt(index) == ')'){
                index = pair[index];
                step = -step;
            }else {
                sb.append(s.charAt(index));
            }
            index+=step;
        }
        return sb.toString();
    }
}
