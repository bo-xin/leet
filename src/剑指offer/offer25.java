package 剑指offer;


public class offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 =l1.next;
            }
            cur = cur.next;
        }
        cur .next = l1 != null ? l1:l2;
        return newHead.next;
    }
}
