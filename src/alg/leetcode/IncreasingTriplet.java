package alg.leetcode;

/**
 * Created by feng on 2016/12/10.
 */
public class IncreasingTriplet {

    public static void main(String[] args) {
        System.out.printf(new IncreasingTriplet().increasingTriplet(new int[]{1, 3, 2, 1, 3}) + "");
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= min) {
                min = n;
            } else if (n <= max) {
                max = n;
            } else {
                return true;
            }
        }
        return false;

    }
}
