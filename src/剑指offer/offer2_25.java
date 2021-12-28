package 剑指offer;

import java.util.Stack;

/**
 * @program: leet
 * @description: 链表中的两数相加
 * @author: Tb
 * @create: 2021-11-29 10:35
 **/
public class offer2_25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l1 : l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode newHead = new ListNode();
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int sum = 0;
            if(!stack1.isEmpty() && !stack2.isEmpty()){
                sum = stack1.pop() + stack2.pop() + carry;
            }else if(!stack1.isEmpty()){
                sum = stack1.pop()+carry;
            }else {
                sum = stack2.pop()+carry;
            }
            carry = sum / 10;
            sum = sum %10;
            ListNode tmp = new ListNode(sum);
            tmp.next = newHead.next;
            newHead.next = tmp;
        }
        if(carry != 0){
            ListNode tmp = new ListNode(carry);
            tmp.next = newHead.next;
            newHead.next = tmp;
        }
        return newHead.next;
    }
}
