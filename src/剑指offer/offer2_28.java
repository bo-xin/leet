package 剑指offer;

/**
 * @program: leet
 * @description: 展平多级双向链表
 * @author: Tb
 * @create: 2021-11-30 10:18
 **/
public class offer2_28 {
    public class Node{
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    public Node dfs(Node node){
        Node cur = node;
        Node last = null;
        while (cur != null){
            Node next = cur.next;
            if(cur.child != null){
                Node childLast = dfs(cur.child);
                cur.next = childLast;
                childLast.prev = cur;
                if(next != null){
                    childLast.next = next;
                    next.prev = childLast;
                }
                cur.child = null;
                last = childLast;
            }else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
