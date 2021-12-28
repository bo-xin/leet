package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leet
 * @description: 重排链表
 * @author: Tb
 * @create: 2021-11-29 10:49
 **/
public class offer2_26 {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            list.add(node);
            node = node.next;
        }
        int i =0,j = list.size()-1;
        while (i < j){
            list.get(i).next = list.get(j);
            i++;
            if(i == j)break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

}
