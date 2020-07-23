package LinkedList;

import com.zzy.Node;

public class FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {

        Node p = head;
        while (p != null) {

            if (p.child == null) {
                p = p.next;
                continue;
            }
            //find child's tail
            Node childTail = p.child;
            while (childTail.next != null)
                childTail = childTail.next;
            //links tail to p.next
            childTail.next = p.next;
            if (p.next != null)
                p.next.prev = childTail;
            //links p to child's head
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }

        return head;
    }


}
