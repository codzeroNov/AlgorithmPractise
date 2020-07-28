package LinkedList;

import com.zzy.ListNode;

public class RemoveDuplicatesFromSortedListII {

/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    Return the linked list sorted as well.
*/

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
                continue;
            }
            if (head.next == fast) {
                head = head.next;
                fast = fast.next;
            } else {
                fast = fast.next;
                head.next = fast;
            }

        }

        if (head.next != fast) head.next = null;
        return dummy.next;
    }
}
