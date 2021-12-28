package 剑指offer;

/**
 * @program: leet
 * @description: 排序的循环链表
 * @author: Tb
 * @create: 2021-11-30 10:38
 **/
public class offer2_29 {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node cur = head;
        while (cur.next != head){
            if(cur.next.val < cur.val){
                if(cur.next.val >= insertVal) break;
                else if(cur.val <= insertVal) break;
            }
            if(cur.val <= insertVal && cur.next.val >= insertVal) break;
            cur = cur.next;
        }
        cur.next = new Node(insertVal,cur.next);
        return head;
    }
}
