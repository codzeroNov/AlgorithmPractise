package LinkedList;

import com.zzy.ListNode;

public class ReverseNodesInKGroup {
/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    Example:
    Given this linked list: 1->2->3->4->5

    For k = 2, you should return: 2->1->4->3->5

    For k = 3, you should return: 3->2->1->4->5

    Note:
    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.
    */

    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        for (ListNode i = head; i != null; i = i.next)
            len++;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (ListNode prev = dummy, cur = head; len >= k; len -= k) {
            for (int i = 1; i < k; i++) {
                ListNode next = cur.next.next;
                //swap nodes
                cur.next.next = prev.next;
                prev.next = cur.next;
                //move cursor
                cur.next = next;
            }

            prev = cur;
            cur = cur.next;
        }

        return dummy.next;
    }
}
