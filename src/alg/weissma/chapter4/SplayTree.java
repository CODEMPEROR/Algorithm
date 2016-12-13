package alg.weissma.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by feng on 16/10/10.
 * 伸展树:伸展树也是一个二叉查找树,不过需要在访问项为X的节点之后,需要将该节点置为树根,从而达到一种平衡的状态.这样不仅降低了项为X的节点的
 * 后续访问时间,也减少了其他节点的深度,从而达到了优化平均访问时间.
 */
public class SplayTree {

    public static void main(String[] args) {
        //build tree;
        int[] vals = new int[25];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = 26 - i;
        }
        SplayTree tree = new SplayTree();
        SplayTreeNode root = tree.buildTree(vals);
        tree.bsf(root);

        for (int i = vals.length - 1; i >= 0; i--) {
            root = tree.traversalAndAdjust(vals[i], root);
        }
    }


    class SplayTreeNode {

        int val;
        SplayTreeNode left;
        SplayTreeNode right;

        SplayTreeNode parent;

        public SplayTreeNode(int val) {
            this.val = val;
        }
    }

    private SplayTreeNode buildTree(int[] vals) {

        SplayTreeNode r, root = new SplayTreeNode(vals[0]);
        r = root;
        root.parent = null;
        int i = 1;
        while (i < vals.length) {
            int x = vals[i];
            SplayTreeNode node = new SplayTreeNode(x);
            while (true) {
                if (root.val > x) {//左子树
                    if (root.left == null) {
                        root.left = node;
                        node.parent = root;
                        break;
                    }
                    root = root.left;
                } else if (root.val < x) {
                    if (root.right == null) {
                        root.right = node;
                        node.parent = root;
                        break;
                    }
                    root = root.right;
                } else {
                    //do nothing;
                }

            }

            i++;
            root = r;
        }

        return r;
    }

    private void bsf(SplayTreeNode root) {
        Queue<SplayTreeNode> stack = new LinkedList<>();
        stack.offer(root);

        while (!stack.isEmpty()) {
            SplayTreeNode node = stack.poll();
            System.out.print(node.val + "p:=" + /*(node.parent == null ? -1 : node.parent.val) +*/ "\t");
            if (node.left != null) {
                stack.offer(node.left);
            }
            if (node.right != null) {
                stack.offer(node.right);
            }
        }
    }


    private SplayTreeNode traversalAndAdjust(int x, SplayTreeNode root) {

        SplayTreeNode t = dfs(root, x);

        if (t == null) {//没有找到目标节点
            return root;
        }


        return null;
    }

    //左单旋转 L
    private void leftSingleRotate(SplayTreeNode node) {
        SplayTreeNode left = node.left;
        node.left = node.parent;
        node.left.right = left;
    }

    //右单旋转
    private void rightSingleRotate(SplayTreeNode node) {
        SplayTreeNode right = node.right;
        node.right = node.parent;
        node.right.left = right;
    }

    //左之字形旋转
    private void leftZigZagRotate(SplayTreeNode node) {
        SplayTreeNode left = node.left;
        SplayTreeNode right = node.right;
        node.left = node.parent;
        node.right = node.parent.parent;
        node.left.right = left;
        node.right.left = right;
    }

    //右之字形旋转
    private void rightZigZagRotate(SplayTreeNode node) {

    }


    //深度遍历找到目标节点x
    private SplayTreeNode dfs(SplayTreeNode root, int x) {
        while (root != null) {
            if (root.val > x) {
                root = root.left;
            } else if (root.val < x) {
                root = root.right;
            } else {
                //可以在此统计深度h
                return root;
            }
        }
        return null;
    }


}
