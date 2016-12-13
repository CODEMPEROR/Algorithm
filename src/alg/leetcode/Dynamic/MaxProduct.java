package alg.leetcode.Dynamic;

/**
 * Created by feng on 16/9/21.
 */
public class MaxProduct {

    public static void main(String[] args) {


        int amount = 2;
        int[] r;
        r = new int[]{1,1,1};

        System.out.println(r.length + "");
        for (int i : r) {
            System.out.printf("" + i);
        }

    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return sub(nums, 1, nums[0]);
    }


    private int sub(int[] n, int i, int currMax) {
        if (i == n.length - 1) {
            return Math.max( n[i] * currMax, Math.max(currMax, n[i]));
        }

        if (i > n.length - 1) {
            return currMax;
        }

        return Math.max(currMax, Math.max(sub(n, i + 1, n[i]), sub(n, i + 1, currMax * n[i])));

    }


}
