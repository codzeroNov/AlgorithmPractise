package BinaryTree;

import com.zzy.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumBinaryTree {
/*

    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    1.The root is the maximum number in the array.
    2.The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    3.The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    Construct the maximum tree by the given array and output the root node of this tree.

            Example 1:
    Input: [3,2,1,6,0,5]
    Output: return the tree root node representing the following tree:

              6
            /   \
           3     5
            \    /
             2  0
              \
               1
*/

/*
    1.traverse the array once and create the node one by one. and use stack to store an increasing sequence.
    2.each step, we create a new curNode. compare to the peek of stack,
        2.a keep popping the stack while (stack.peek().val < curNode.val), and set the last popping node to be curNode.left.
        Because the last one fulfilling the criteria is the largest number among curNode's left children. => curNode.left = last pop node
        2.b after popping up all nodes that fulfill (stack.peek().val < curNode.val),
        thus (stack.peek().val > curNode.val), the stack.peek() is curNode's root => peek.right = curNode
    3.return the bottom node of stack.
*/

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode cur = new TreeNode(nums[i]);

            while (!stack.isEmpty() && stack.peek().val < nums[i])
                cur.left = stack.pop();
            if (!stack.isEmpty() && stack.peek().val > nums[i])
                stack.peek().right = cur;

            stack.push(cur);
        }

        return stack.removeLast();
    }

    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;

        int idxMax = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[idxMax])
                idxMax = i;
        }

        TreeNode node = new TreeNode(nums[idxMax]);

        node.left = build(nums, left, idxMax - 1);
        node.right = build(nums, idxMax + 1, right);

        return node;
    }

}
