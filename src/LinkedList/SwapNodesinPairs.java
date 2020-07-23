package LinkedList;

import com.zzy.ListNode;

public class SwapNodesinPairs {
/*

    Given a linked list, swap every two adjacent nodes and return its head.
    You may not modify the values in the list's nodes, only nodes itself may be changed.

    Example:
    Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            head = prev.next;
        }

        return dummy.next;
    }

}
