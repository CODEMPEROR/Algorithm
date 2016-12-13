package alg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by feng on 16/9/15.
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTravsersal {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }


    ///////非递归版本
    private void preorderTraversalNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            System.out.print(node.val + ",");
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }


    ///////递归版本
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        find(root, list);
        return list;

    }

    private void find(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        find(root.left, res);
        find(root.right, res);
    }
}
