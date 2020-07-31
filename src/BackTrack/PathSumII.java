package BackTrack;

import com.zzy.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    /*
        Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
        Note: A leaf is a node with no children.
    */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode node, int remain, List<List<Integer>> res, List<Integer> sub) {
        if (node == null)
            return;

        sub.add(node.val);

        if (node.left == null && node.right == null && remain == node.val) {
            res.add(new ArrayList<>(sub));
        } else {
            helper(node.left, remain - node.val, res, sub);
            helper(node.right, remain - node.val, res, sub);
        }

        sub.remove(sub.size() - 1);
    }
}
