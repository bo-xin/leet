package 链表;

public class leet234 {
    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return dfs(head);
    }
    public boolean dfs(ListNode head){
        if(head == null) return true;
        boolean res = dfs(head.next);
        res = res & (head.val == left.val);
        left = left.next;
        return res;
    }
}
