package alg.leetcode;

import java.util.HashMap;

/**
 * Created by feng on 2016/12/4.
 */
public class Sum4II {

    public static void main(String[] args) {
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> abMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                abMap.put(sum, abMap.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                res += abMap.getOrDefault(-sum, 0);
            }
        }
        return res;
    }
}
