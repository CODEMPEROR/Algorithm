package alg.weissma.chapter2;

/**
 * Created by feng on 16/9/29.
 */
public class MinSubSeqSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, 35, -5, -2, -1, -2, 6, -2};
        int r = new MinSubSeqSum().minSum(nums);
        System.out.println(r);
    }


    private int minSum(int[] nums) {
        int minSum = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] > 0){
                sum = 0;
            }else if (sum < minSum){
                minSum = sum;
            }
        }

        return minSum;
    }

}
