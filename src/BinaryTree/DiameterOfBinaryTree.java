package BinaryTree;

import com.zzy.TreeNode;

public class DiameterOfBinaryTree {

    //Given a binary tree, you need to compute the length of the diameter of the tree.
    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    // This path may or may not pass through the root.

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        max = Math.max(max, left + right);

        return 1 + Math.max(left, right);
    }

}
