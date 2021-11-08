package 链表;

public class leet92 {
    ListNode nextNode = null;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next==null) return head;
        if(m == 1) return reverseN(head,n);
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }
    public ListNode reverseN(ListNode head,int n){
        if(n == 1){
            nextNode = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = nextNode;
        return last;
    }
}
