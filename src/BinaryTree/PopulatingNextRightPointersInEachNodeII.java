package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    /*
        Populate each next pointer to point to its next right node.
        If there is no next right node, the next pointer should be set to NULL.
        Initially, all next pointers are set to NULL.
    */
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (i < size - 1)
                    curr.next = q.peek();
                else
                    curr.next = null;

                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);

            }

        }

        return root;
    }

    public Node connect2(Node root) {
        if (root == null)
            return null;

        Node curr = root;//current level node
        Node nextDummyHead = new Node(0);//next level dummy head
        Node p = nextDummyHead;//the pointer to link nodes in next level

        while (curr != null) {
            if (curr.left != null) {
                p.next = curr.left;
                p = p.next;
            }
            if (curr.right != null) {
                p.next = curr.right;
                p = p.next;
            }

            if (curr.next != null) {
                curr = curr.next;
            } else {
                curr = nextDummyHead.next;
                nextDummyHead.next = null;//cut the list, in case when we traverse in the leaf nodes we get a infinite loop
                p = nextDummyHead;
            }
        }

        return root;
    }

    public Node connect3(Node root) {
        if (root == null)
            return null;

        Node curr = root;//current level node
        Node nextDummyHead = new Node(0);//next level dummy head
        Node p = nextDummyHead;//the pointer to link nodes in next level

        //outer loop go through top to bottom of the tree
        while (curr != null) {
            //inner loop go through nodes in the same level
            while (curr != null) {
                if (curr.left != null) {
                    p.next = curr.left;
                    p = p.next;
                }
                if (curr.right != null) {
                    p.next = curr.right;
                    p = p.next;
                }
                curr = curr.next;
            }
            curr = nextDummyHead.next;
            nextDummyHead.next = null;
            p = nextDummyHead;
        }

        return root;
    }
}
