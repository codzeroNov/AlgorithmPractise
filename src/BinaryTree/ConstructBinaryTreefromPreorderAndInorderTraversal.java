package BinaryTree;

import com.zzy.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderAndInorderTraversal {


    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return helper1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode helper1(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> inMap) {
        if (pStart > pEnd)
            return null;
        TreeNode root = new TreeNode(preorder[pStart]);
        if (pStart == pEnd)
            return root;
        int index = inMap.get(preorder[pStart]);
        root.left = helper1(preorder, pStart + 1, pStart + index - iStart, inorder, iStart, index - 1, inMap);
        root.right = helper1(preorder, pEnd - (iEnd - index) + 1, pEnd, inorder, index + 1, iEnd, inMap);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode cur = stack.peek();
            if (preorder[i] != inorder[index]) {
                cur.left = new TreeNode(preorder[i]);
                stack.push(cur.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[index]) {
                    cur = stack.pop();
                    index++;
                }
                cur.right = new TreeNode(preorder[i]);
                stack.push(cur.right);
            }
        }

        return root;
    }
}
