package alg.weissma.chapter4;

/**
 * Created by feng on 16/10/8.
 * AVLTree Training
 */
public abstract class MyAVLTree<T> {

    public class AVLTreeNode<T> {
        public AVLTreeNode(T v) {
            this.val = v;
        }

        AVLTreeNode<T> left;
        AVLTreeNode<T> right;
        T val;
        int height;


    }

    public int getHeight(AVLTreeNode node) {
        return null == node ? -1 : node.height;
    }

    public AVLTreeNode<T> insert(T x, AVLTreeNode<T> root) {
        if (null == root) {
            return new AVLTreeNode<>(x);
        }

        int comp = compare(x, root.val);

        if (comp > 0) {//R
            root.right = insert(x, root.right);

            if (getHeight(root.right) - getHeight(root.left) == 2) {
                if (compare(x, root.right.val) > 0) { //R
                    root = rr(root);
                } else {//L
                    root = rl(root);
                }
            }
        } else if (comp < 0) {// L
            root.left = insert(x, root.left);

            if (getHeight(root.left) - getHeight(root.right) == 2) {
                if (compare(x, root.left.val) > 0) { //R
                    root = lr(root);
                } else { //L
                    root = ll(root);
                }
            }
        } else {// if equal, then ignore.
            //do Nothing
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    public AVLTreeNode<T> remove(T x){
        return null;
    }


    private AVLTreeNode<T> rr(AVLTreeNode<T> root) {
        AVLTreeNode<T> child = root.right;
        root.right = child.left;
        child.left = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;
        return child;
    }


    private AVLTreeNode<T> rl(AVLTreeNode<T> root) {
        root.right = ll(root.right);
        return rr(root);
    }

    private AVLTreeNode<T> ll(AVLTreeNode<T> root) {
        AVLTreeNode<T> child = root.left;
        root.left = child.right;
        child.right = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        child.height = Math.max(getHeight(root), getHeight(child.left)) + 1;
        return child;
    }


    private AVLTreeNode<T> lr(AVLTreeNode<T> root) {
        root.left = rr(root.left);
        return ll(root);
    }

    public abstract int compare(T x, T v);

}
