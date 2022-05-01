package LinkedList;

import com.zzy.ListNode;

public class ReverseLinkedList {

    public ListNode ReverseList(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

}
