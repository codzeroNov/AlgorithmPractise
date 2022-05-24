package BinaryTree;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
    /*
    One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

         _9_
        /   \
       3     2
      / \   / \
     4   1  #  6
    / \ / \   / \
    # # # #   # #
    For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

    Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

    Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

    You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
    */
    public boolean isValidSerialization(String preorder) {
        /**
         * all non-null node provides 2 out-degree and 1 in-degree (2 children and 1 parent), except root
         * all null node provides 0 out-degree and 1 in-degree (0 child and 1 parent).
         * diff = out-degree - in-degree
         */
        String[] nodes = preorder.split(",");

        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0)
                return false;
            if (!node.equals("#"))
                diff += 2;
        }

        return diff == 0;
    }

    /**
     * when you iterate through the preorder traversal string, for each char:
     *
     * case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack
     *
     * case 2.1: you see a #, while top of stack is a number, you know this # is a left null child, put it there as a mark for next coming node k to know it is being the right child.
     *
     * case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child, you now cancel the subtree (rooted as t, for example) with these two-# children.
     * But wait, after the cancellation, you continue to check top of stack is whether # or a number:
     *
     * 2.2.1 if a number, say u, you know you just cancelled a node t which is left child of u. You need to leave a # mark to the top of stack. So that the next node know it is a right child.
     *
     * 2.2.2 if a #, you know you just cancelled a tree whose root, t, is the right child of u. So you continue to cancel subtree of u, and the process goes on and on.
     */
    public boolean isValidSerialization2(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> s = new Stack<>();

        for (String node : nodes) {
            while (node.equals("#") && !s.isEmpty() && s.peek().equals("#")) {
                s.pop();
                if (s.isEmpty())
                    return false;
                s.pop();
            }
            s.push(node);
        }

        return s.size() == 1 && s.peek().equals("#");
    }
}
