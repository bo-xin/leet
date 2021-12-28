package 剑指offer;

/**
 * @program: leet
 * @description: 删除链表的倒数第 n 个结点
 * @author: Tb
 * @create: 2021-11-28 11:08
 **/
public class offer2_21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = head;
        while (n > 0){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = tmp.next;
        tmp.next = null;
        return newHead.next;
    }
}
