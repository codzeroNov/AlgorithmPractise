package LinkedList;

import com.zzy.ListNode;

public class PartitionList {

    /*
        Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
        You should preserve the original relative order of the nodes in each of the two partitions.

        Example:
        Input: head = 1->4->3->2->5->2, x = 3
        Output: 1->2->2->4->3->5
    */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode dummy1 = new ListNode(0);
        ListNode p = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode q = dummy2;

        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }

        if (dummy2.next != null)
            p.next = dummy2.next;

        q.next = null;

        return dummy1.next;
    }
}
