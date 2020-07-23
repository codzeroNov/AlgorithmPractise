package BinaryTree;

import com.zzy.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    //给定一个二叉树，检查它是否是镜像对称的。

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            if (p == null && q == null)
                continue;

            if (p == null || q == null || p.val != q.val)
                return false;

            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }

        return true;
    }

}
