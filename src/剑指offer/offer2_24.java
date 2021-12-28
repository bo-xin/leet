package 剑指offer;

/**
 * @program: leet
 * @description: 反转链表
 * @author: Tb
 * @create: 2021-11-29 10:00
 **/
public class offer2_24 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
