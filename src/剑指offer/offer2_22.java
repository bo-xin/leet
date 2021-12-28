package 剑指offer;

/**
 * @program: leet
 * @description: 链表中环的入口节点
 * @author: Tb
 * @create: 2021-11-28 11:03
 **/
public class offer2_22 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
