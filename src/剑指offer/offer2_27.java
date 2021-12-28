package 剑指offer;

/**
 * @program: leet
 * @description: 回文链表
 * @author: Tb
 * @create: 2021-11-30 09:56
 **/
public class offer2_27 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode firstHalfNode = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfNode.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null){
            if(p1.val != p2.val){
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfNode.next = reverseList(secondHalfStart);
        return result;
    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTmp;
        }
        return pre;
    }
    public ListNode endOfFirstHalf(ListNode head){
        ListNode fast= head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
