package BinaryTree;

import com.zzy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    //给定一个二叉树，找出其最大深度。
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0, size;
        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

            }
        }

        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        return 1 + Math.max(left, right);
    }

}
