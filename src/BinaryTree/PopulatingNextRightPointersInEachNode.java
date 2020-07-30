package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    /*
        You are given a perfect binary tree where all leaves are on the same level,
        and every parent has two children.

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

    //level-traversal TIME:O(N);SPACE:O(N)
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

    //TIME:O(N);SPACE:O(1);
    public Node connect2(Node root) {
        //outer loop traverse from top to bottom, level to level
        Node levelStart = root;
        while (levelStart != null) {
            //inner loop traverse from left to right in the same level
            Node current = levelStart;
            while (current != null) {
                if (current.left != null)
                    current.left.next = current.right;
                if (current.next != null && current.right !=null)
                    current.right.next = current.next.left;

                current = current.next;
            }

            levelStart = levelStart.left;
        }

        return root;
    }

    //recursive methods, TIME:O(N), SPACE:O(N)
    public Node connect3(Node root) {
        if (root == null)
            return null;
        helper(root.left, root.right);
        return root;
    }

    private void helper(Node n1, Node n2) {
        if (n1 == null) return;
        n1.next = n2;
        helper(n1.left, n1.right);
        helper(n2.left, n2.right);
        helper(n1.right, n2.left);
    }
}
