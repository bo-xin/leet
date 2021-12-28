package 剑指offer;

/**
 * @program: leet
 * @description: 两个链表的第一个重合节点
 * @author: Tb
 * @create: 2021-11-28 10:40
 **/
public class offer2_23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null) return null;
        ListNode pA = headA,pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
