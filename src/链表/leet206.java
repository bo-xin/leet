package 链表;

public class leet206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
