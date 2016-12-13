package alg.weissma.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by feng on 16/10/7.
 */
public class Test {

    public static void main(String[] args) {
        MyAVLTree<Integer> avl = new MyAVLTree<Integer>() {
            @Override
            public int compare(Integer x, Integer v) {
                return x - v;
            }
        };


        MyAVLTree<Integer>.AVLTreeNode<Integer> root = avl.insert(3, null);
        root = avl.insert(2, root);
        root = avl.insert(1, root);
        int i = 3;
        while (i++ < 7){
            root = avl.insert(i, root);
        }

        i = 17;
        while (i-- > 9){
            root = avl.insert(i, root);
        }

        root = avl.insert(8, root);
        root = avl.insert(9, root);

        new Test().bsf(root);
    }


    //广度优先遍历
    private void bsf(MyAVLTree<Integer>.AVLTreeNode<Integer> root){
        Queue<MyAVLTree<Integer>.AVLTreeNode<Integer>> stack = new LinkedList<>();
        stack.offer(root);

        while (!stack.isEmpty()){
            MyAVLTree<Integer>.AVLTreeNode<Integer> node = stack.poll();
            System.out.print(node.val + " \t");
            if (node.left != null){
                stack.offer(node.left);
            }
            if (node.right != null){
                stack.offer(node.right);
            }
        }
    }

}
