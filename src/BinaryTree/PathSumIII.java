package BinaryTree;

import com.zzy.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    /*
    You are given a binary tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     */
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, sum, 0);
    }

    private int dfs(TreeNode node, Map<Integer, Integer> prefix, int target, int currSum) {
        if (node == null) return 0;

        currSum += node.val;
        int res = prefix.getOrDefault(currSum - target, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);

        res += dfs(node.left, prefix, target, currSum) + dfs(node.right, prefix, target, currSum);
        prefix.put(currSum, prefix.get(currSum) - 1);
        return res;
    }
}
