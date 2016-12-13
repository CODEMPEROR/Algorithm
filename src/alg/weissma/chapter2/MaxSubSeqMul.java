package alg.weissma.chapter2;

/**
 * Created by feng on 16/9/29.
 */
public class MaxSubSeqMul {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 35, -5, -2, -1, -2, 6, -3};
        int r = new MaxSubSeqMul().maxMul(nums);
        System.out.println(r);
    }

    private int maxMul(int[] nums){


        int[] maxMul = new int[nums.length];
        int[] minMul = new int[nums.length];
        int max = maxMul[0] = minMul[0] = nums[0];

        for (int i = 1; i < nums.length; i++){
            maxMul[i] = Math.max(Math.max(maxMul[i-1] * nums[i], nums[i]), minMul[i-1] * nums[i]);
            minMul[i] = Math.min(Math.min(maxMul[i-1] * nums[i], nums[i]), minMul[i-1] * nums[i]);
            max = Math.max(max, maxMul[i]);
        }

        return max;
    }

}
