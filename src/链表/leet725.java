package 链表;

public class leet725 {
    ListNode[] res;
    public ListNode[] splitListToParts(ListNode head, int k) {
        res = new ListNode[k];
        int cnt = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            cnt++;
        }
        int pre = cnt / k;
        int remain = cnt % k;
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int size = pre + (i < remain ? 1 : 0);
            for (int j = 1; j < size; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
