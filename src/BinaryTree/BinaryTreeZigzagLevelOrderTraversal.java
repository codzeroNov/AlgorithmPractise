package BinaryTree;

import com.zzy.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        int size = 1;
        boolean leftToRight = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> sub = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (leftToRight)
                    sub.add(curr.val);
                else
                    sub.add(0, curr.val);

                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }

            lists.add(sub);
            size = queue.size();
            leftToRight = !leftToRight ;
        }

        return lists;
    }
}
