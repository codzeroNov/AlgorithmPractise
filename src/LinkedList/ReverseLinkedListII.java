package LinkedList;

import com.zzy.ListNode;

public class ReverseLinkedListII {
/*
    Reverse a linked list from position m to n. Do it in one-pass.
    Note: 1 ≤ m ≤ n ≤ length of list.
*/

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start, prev, then;
        prev = dummy;

        for (int i = 0; i < m - 1; i++)
            prev = prev.next;

        start = prev.next;
        while (n - m > 0) {
            then = start.next;
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;

            n--;
        }

        return dummy.next;
    }
}
