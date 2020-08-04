package LinkedList;

public class CopyListWithRandomPointer {
/*

    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.

    The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
*/

    private class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node cur = head, copy;

        //copy
        while (cur != null) {
            Node newNode = new Node(cur.val);
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
        Node dummyCopyHead = new Node(0);
        dummyCopyHead.next = head.next;
        cur = head;
        while (cur != null) {
            Node curNxt = cur.next.next;
            copy = cur.next;
            if (copy.next != null)
                copy.next = copy.next.next;
            cur.next = curNxt;
            cur = curNxt;
        }
        return dummyCopyHead.next;
    }

}
