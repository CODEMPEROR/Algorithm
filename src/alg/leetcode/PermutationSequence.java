package alg.leetcode;

import java.util.LinkedList;

/**
 * Created by feng on 2016/10/22.
 */
public class PermutationSequence {

    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3, 1);
    }

    public String getPermutation(int n, int k) {

        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        k = k - 1;
        for (int i = n; i > 0; i--) {
            int group = k / factorial[i - 1];
            k = k % factorial[i - 1];
            sb.append(list.get(group));
            list.remove(group);
        }

        return sb.toString();
    }
}
