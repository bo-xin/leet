package 剑指offer;



public class offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode cur = temp;
        while (cur.next!=null && cur.next.val != val){
            cur = cur.next;
        }
        if(cur.next.val == val){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = null;
        }
        return temp.next;
    }
}
