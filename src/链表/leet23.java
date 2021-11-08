package 链表;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leet23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode dummpy = new ListNode();
        ListNode temp = dummpy;
        for (ListNode node : lists) {
            if (node!=null){
                pq.add(node);
            }
        }
        while (!pq.isEmpty()){
            ListNode cur = pq.poll();
            temp.next = cur;
            temp = temp.next;
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return dummpy.next;
    }
}
