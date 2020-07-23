package BinaryTree;

import com.zzy.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestorOfABinaryTree {

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        boolean lson = dfs(node.left, p, q);
        boolean rson = dfs(node.right, p, q);
        if ((lson && rson) || ((lson || rson) && (node.val == p.val || node.val == q.val)))
            ans = node;

        return lson || rson || node.val == p.val || node.val == q.val;
    }

    //======================================================================================


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, TreeNode> child2parent = new HashMap<>();
        dfs2(child2parent, root);

        HashSet<Integer> visited = new HashSet<>();

        while (p != null) {
            visited.add(p.val);
            p = child2parent.get(p.val);
        }

        while (q != null) {
            if (visited.contains(q.val))
                return q;
            q = child2parent.get(q.val);
        }

        return null;
    }

    private void dfs2(HashMap<Integer, TreeNode> child2parent, TreeNode root) {
        if (root.left != null) {
            child2parent.put(root.left.val, root);
            dfs2(child2parent, root.left);
        }
        if (root.right != null) {
            child2parent.put(root.right.val, root);
            dfs2(child2parent, root.right);
        }
    }


}
