package 剑指offer;

import java.util.Stack;

public class offer06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (head!=null){
            stack.push(head.val);
            head = head.next;
            len++;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
