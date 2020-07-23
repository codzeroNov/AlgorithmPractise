package BinaryTree;

import com.zzy.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return null;

        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return helper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    private TreeNode helper(int[] postorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> inMap) {
        if (pStart > pEnd) return null;
        TreeNode root = new TreeNode(postorder[pEnd]);
        if (pStart == pEnd) return root;
        int idx = inMap.get(postorder[pEnd]);
        root.left = helper(postorder, pStart, pStart+(idx-iStart)-1, inorder, iStart, idx-1, inMap);
        root.right = helper(postorder, pStart+idx-iStart, pEnd-1, inorder, idx+1, iEnd, inMap);
        return root;
    }
}
