package BinaryTree;

import com.zzy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0, size;

        while (!q.isEmpty()) {
            depth++;
            size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null & node.right == null)
                    return depth;

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return depth;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        if (left == 0 || right == 0)
            return 1 + left + right; // a leaf node is without children
        return 1 + Math.min(left, right);
    }

}
