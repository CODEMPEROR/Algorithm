package alg.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Created by feng on 2016/11/1.
 *
 * Huffman,学生成绩概率分布统计示例
 */
public class Huffman {

    public static void main(String[] args) {
        int[] datas = new int[1000000];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = new Random().nextInt(60) + 40;
        }
        Huffman huffman = new Huffman();
        huffman.huffman(datas);
    }

    public void huffman(int[] datas) {
        int[] standard = new int[]{60, 70, 80, 90, 100};
        float[] probability = new float[]{.06f, .42f, 0.4f, .07f, 0.05f};

        HuffmanNode root = buildHuffmanTree(probability);

        printHuffman(root);

        long start = System.nanoTime();
        for (int i = 0; i < datas.length; i++) {
            int tmp = datas[i];
            if (tmp <= 70 && tmp > 60) {
            } else if (tmp <= 80 && tmp > 70) {

            } else if (tmp <= 90 && tmp > 80) {

            } else if (tmp <= 60 && tmp >= 0) {

            } else if (tmp <= 100 && tmp > 90) ;
        }

        long end = System.nanoTime();
        System.out.printf("Total time consumed : " + (end - start));

    }


    /**
     * 构造huffman树
     *
     * @param p
     * @return
     */
    public HuffmanNode buildHuffmanTree(float[] p) {
        List<HuffmanNode> nodes = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            nodes.add(new HuffmanNode(p[i]));
        }

        while (nodes.size() >= 2) {
            HuffmanNode min = findMinNode(nodes);
            removeNode(nodes, min);
            HuffmanNode next = findMinNode(nodes);
            removeNode(nodes, next);
            HuffmanNode root = new HuffmanNode(min.val + next.val);
            root.left = min;
            root.right = next;
            addNode(nodes, root);
        }

        return nodes.get(0);

    }


    /**
     * 找到最小元
     * @param huffmanNodes
     * @return
     */
    public HuffmanNode findMinNode(List<HuffmanNode> huffmanNodes) {
        HuffmanNode min = huffmanNodes.get(0);
        for (int i = 1; i < huffmanNodes.size(); i++) {
            if (huffmanNodes.get(i).val < min.val) {
                min = huffmanNodes.get(i);
            }
        }

        return min;
    }

    /**
     * 向Huffman树中添加新的节点
     * @param huffmanNodes
     * @param target
     */
    public void addNode(List<HuffmanNode> huffmanNodes, HuffmanNode target) {
        huffmanNodes.add(target);
    }

    /**
     * 移除Huffman中的某个节点
     * @param huffmanNodes
     * @param target
     */
    public void removeNode(List<HuffmanNode> huffmanNodes, HuffmanNode target) {
        huffmanNodes.remove(target);
    }

    /**
     * 打印Huffman树
     * @param root
     */
    public void printHuffman(HuffmanNode root) {
        if (root == null) return;
        Stack<HuffmanNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            HuffmanNode node = stack.pop();
            System.out.printf(node.val + "\t");
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        System.out.println("\n");

    }

    public class HuffmanNode {
        float val;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(float val) {
            this.val = val;
        }
    }
}
