package 剑指offer;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: leet
 * @description: 链表排序
 * @author: Tb
 * @create: 2021-12-17 10:35
 **/
public class offer2_77 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        while (head != null){
            pq.offer(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public ListNode sortList1(ListNode head){
        return sortList(head);
    }
    public ListNode sort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode L = sort(head);
        ListNode R = sort(head2);
        return merger(L,R);
    }
    public ListNode merger(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) cur.next = head1;
        if(head2 != null) cur.next = head2;
        return dummy.next;
    }
}
