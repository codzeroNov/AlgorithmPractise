package BinaryTree;

import com.zzy.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;

        Queue<TreeNode> q = new LinkedList<>();
        int size = 1;
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> sub = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sub.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            lists.add(sub);
            size = q.size();
        }

        return lists;
    }

}
