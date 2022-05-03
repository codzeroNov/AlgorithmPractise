package LinkedList;

import com.zzy.ListNode;

public class RemoveDuplicatesFromSortedListII {

/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    Return the linked list sorted as well.
*/

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                continue;
            }

            if (head.next != curr) {
                head.next = curr.next;
            } else {
                head = head.next;
            }

            curr = curr.next;
        }


        return dummy.next;
    }
}
