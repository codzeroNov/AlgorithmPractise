package LinkedList;

import com.zzy.RandomNode;

public class CopyListWithRandomPointer {
/*

    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.

    The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
*/

    public RandomNode copyRandomList(RandomNode head) {
        if (head == null)
            return null;

        RandomNode cur = head, copy;

        //copy
        while (cur != null) {
            RandomNode newNode = new RandomNode(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        //assign random pointer
        cur = head;
        while (cur != null) {
            copy = cur.next;
            if (cur.random != null)
                copy.random = cur.random.next;
            cur = cur.next.next;
        }
        //extract copy list
        RandomNode dummyCopyHead = new RandomNode(0);
        dummyCopyHead.next = head.next;
        cur = head;
        while (cur != null) {
            RandomNode curNxt = cur.next.next;
            copy = cur.next;
            if (copy.next != null)
                copy.next = copy.next.next;
            cur.next = curNxt;
            cur = curNxt;
        }
        return dummyCopyHead.next;
    }

}
