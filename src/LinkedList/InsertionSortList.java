package LinkedList;

import com.zzy.ListNode;

public class InsertionSortList {
    //Sort a linked list using insertion sort.
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while (head != null) {
            ListNode nextInsertNode = head.next;
            /*
            Before insert, the prev is at the last node of the sorted list.
            Only the last node's value is larger than the current inserting node
            should we move the temp back to the head
            */
            if (prev.val >= head.val)
                prev = dummy;// reset prev node to head and start over

            while (prev.next != null && prev.next.val < head.val)
                prev = prev.next;

            //insert original node into new list
            head.next = prev.next;
            prev.next = head;

            head = nextInsertNode;
        }

        return dummy.next;
    }
}
