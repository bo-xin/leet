package 链表;

public class leet430 {
    public Node flatten(Node head) {
        //对边界条件进行处理
        Node dummpy = new Node();
        dummpy.next = head;
        dfs(head);
        return dummpy.next;
    }
    // 递归函数，作用返回节点链表扁平化后的头结点
    public Node dfs(Node head){
        // 替代头结点位置，方便返回
        Node cur = head;
        // 当前结点不为空遍历
        while (cur != null){
            //当前没有孩子节点，cur= cur.next
            if(cur.child == null){
                cur = cur.next;
            }else {
                // 当前节点有child，记录当前节点的下一个节点
                Node nextOne = cur.next;
                // 记录孩子链表返回的节点
                Node childHead = dfs(cur.child);
                // 使cur.next = childHead,扁平化一层链表
                cur.next = childHead;
                childHead.prev = cur;
                cur.child = null;
                // 连接上一层链表的next节点
                while (cur.next != null) cur = cur.next;
                cur.next = nextOne;
                if(nextOne != null) nextOne.prev = cur;
            }
        }
        return head;
    }

    public Node flatten1(Node head) {
        // 边界条件处理
        Node dummpy = new Node();
        dummpy.next = head;
        while (head != null){
            // 判断是否有孩子节点，没有继续
            if(head.child == null){
                head = head.next;
            }else {
                // 记录本级链表的下一个节点
                Node nextOne = head.next;
                // 记录孩子链表的最后一个节点
                Node last = head;
                // 扁平化链表
                Node childHead = head.child;
                head.next = childHead;
                childHead.prev = head;
                head.child = null;
                // 连接上一级的next节点
                while (last.next != null) last = last.next;
                last.next = nextOne;
                if(nextOne != null) nextOne.prev = last;
            }
        }
        return dummpy.next;
    }
}
