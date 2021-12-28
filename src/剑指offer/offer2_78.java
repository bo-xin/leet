package 剑指offer;

import java.util.PriorityQueue;

/**
 * @program: leet
 * @description: 合并排序链表
 * @author: Tb
 * @create: 2021-12-17 10:58
 **/
public class offer2_78 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node : lists) {
            while (node != null){
                pq.offer(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()){
            cur.next = pq.poll();
            cur =cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for (ListNode node : lists) {
            if(node != null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null){
                pq.offer(temp.next);
            }
        }
        return dummy.next;
    }
}
