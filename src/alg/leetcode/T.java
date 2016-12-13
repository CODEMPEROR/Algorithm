package alg.leetcode;

/**
 * Created by feng on 16/9/17.
 */
public class T {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        return doIt(null, nums, 0, nums.length - 1);
    }

    private TreeNode doIt(TreeNode root, int[] nums, int left, int right) {

        if (left > right){
            return null;
        }

        int mid = (left + right) / 2;
        if (root == null) {
            root = new TreeNode(nums[mid]);
        }
        root.left = doIt(null, nums, 0, mid - 1);
        root.right = doIt(null, nums, mid + 1, right);

        return root;
    }
}
