package alg.weissma.chapter4;

/**
 * Created by feng on 16/10/8.
 * AVLTree Training
 */
public abstract class AVLTree<T> {

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

        if (comp > 0) {
            root.right = insert(x, root.right);

            if (getHeight(root.right) - getHeight(root.left) == 2) {
                if (compare(x, root.right.val) > 0) { //右右
                    root = rotateWithRightChild(root);
                } else {
                    root = doubleRotateWithRightChild(root);
                }
            }
        } else if (comp < 0) {
            root.left = insert(x, root.left);

            if (getHeight(root.left) - getHeight(root.right) == 2) {
                if (compare(x, root.left.val) > 0) {
                    root = doubleRotateWithLeftChild(root);
                } else {
                    root = rotateWithLeftChild(root);
                }
            }
        } else {
            //do Nothing
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }


    private AVLTreeNode<T> rotateWithRightChild(AVLTreeNode<T> root) {
        AVLTreeNode<T> child = root.right;
        root.right = child.left;
        child.left = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;
        return child;
    }


    private AVLTreeNode<T> doubleRotateWithRightChild(AVLTreeNode<T> root) {
        root.right = rotateWithLeftChild(root.right);
        return rotateWithRightChild(root);
    }

    private AVLTreeNode<T> rotateWithLeftChild(AVLTreeNode<T> root) {
        AVLTreeNode<T> child = root.left;
        root.left = child.right;
        child.right = root;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        child.height = Math.max(getHeight(root), getHeight(child.left)) + 1;
        return child;
    }


    private AVLTreeNode<T> doubleRotateWithLeftChild(AVLTreeNode<T> root) {
        root.left = rotateWithRightChild(root.left);
        return rotateWithLeftChild(root);
    }

    public abstract int compare(T x, T v);

}
