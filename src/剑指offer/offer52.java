package 剑指offer;

public class offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB==null) return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != cur2){
            if (cur1 == null) cur1 = headB;
            else cur1 = cur1.next;
            if (cur2 == null) cur2 = headA;
            else cur2 = cur2.next;

        }
        return cur1;
    }
}
