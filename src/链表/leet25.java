package 链表;

import java.util.List;

public class leet25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode a = head,b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null,nxt = a,cur = a;
        while (cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
