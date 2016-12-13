package alg.weissma.chapter4;

import java.util.Iterator;

/**
 * Created by feng on 2016/10/11.
 */
public abstract class MyTreeSet<T> {

    public class TreeNode {
        T val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(T val) {
            this.val = val;
        }
    }

    private TreeNode min; //最小值为索引

    public abstract int compare(T x, T y);

    public TreeNode add(T x, TreeNode root) {

        TreeNode node = new TreeNode(x);

        if (null == root) {
            return node;
        }

        //建立索引
        if (min == null) {
            min = compare(x, root.val) < 0 ? node : root;
        } else {
            min = compare(min.val, x) < 0 ? min : node;
        }

        TreeNode tmp = root;

        while (true) {
            int comp = compare(x, root.val);
            if (comp < 0) {
                if (tmp.left == null) {
                    tmp.left = node;
                    node.parent = tmp; //建立parent索引
                    break;
                }
                tmp = tmp.left;
            } else if (comp > 0) {

                if (null == tmp.right) {
                    tmp.right = node;
                    node.parent = tmp; //建立parent索引
                    break;
                }
                tmp = tmp.right;
            } else {
                //相同,do Nothing
            }
        }

        return root;
    }

    public TreeNode remove(T x, TreeNode root) {
        return null;
    }

    public Iterator<T> iterator(){
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }


}
