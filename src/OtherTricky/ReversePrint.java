package OtherTricky;

import java.util.LinkedList;
import java.util.Stack;

public class ReversePrint {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cursor = head;

        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.next;
        }

        int[] ret = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ret[i++] = stack.pop().val;
        }

        return ret;
    }
}
