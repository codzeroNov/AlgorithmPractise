package LinkedList;

import com.zzy.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;//cut
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }

        if (left != null) p.next = left;
        if (right != null) p.next = right;

        return dummy.next;
    }

}
