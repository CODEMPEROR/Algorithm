package alg.weissma.chapter2;

/**
 * Created by feng on 16/9/28.
 */
public class MaxSubSeqSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -3, -5, -2, -1, -2, 6, -2};
        int r = new MaxSubSeqSum().maxSum(nums, 0, nums.length - 1);
        System.out.printf("result = " + r + "\n");
        System.out.printf("maxSumMoreEfficient:" + new MaxSubSeqSum().maxSumMoreEfficient(nums));

    }


    private int maxSumMoreEfficient(int[] nums) {
        int maxSum = 0, sum = 0;
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }else if (sum < 0){
                sum = 0;
                right = i;

            }
        }

        return maxSum;
    }


    private int maxSum(int[] nums, int left, int right) {

        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftSum = maxSum(nums, left, mid);
        int rightSum = maxSum(nums, mid + 1, right);

        int leftBorderSum = 0, maxLeftBorderSum = 0;

        for (int i = mid; i >= left; i--) {
            leftBorderSum += nums[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }


        int rightBorderSum = 0, maxRightBorderSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightBorderSum += nums[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }


        return Math.max(Math.max(leftSum, rightSum), maxLeftBorderSum + maxRightBorderSum);
    }
}
