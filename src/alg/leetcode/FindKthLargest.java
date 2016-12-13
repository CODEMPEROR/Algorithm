package alg.leetcode;

/**
 * Created by feng on 2016/10/28.
 */
public class FindKthLargest {

    public static void main(String[] args) {
        System.out.printf(new FindKthLargest().findKthLargest(new int[]{10, 2, 31, 5, 12, 3, 21, 12, 5, 6}, 3) + "");
        ;
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }

        return partition(nums, 0, nums.length - 1, k);
    }

    private int partition(int[] nums, int left, int right, int k) {
        if (left > right) return -1;
        int pivot = nums[left];
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[r] > pivot) r--;
            while (l < r && nums[l] <= pivot) l++;
            System.out.println("left = " + nums[l] + "\t right = " + nums[r]);
            if (l != r) exchange(nums, l, r);
        }

        if (left != l)exchange(nums, l, left);

        if (k == nums.length - r) {
            return nums[r];
        } else if (k > nums.length - r) return partition(nums, left, r - 1, k);
        else return partition(nums, r + 1, right, k);

    }

    private void exchange(int nums[], int l, int r) {
        nums[l] ^= nums[r];
        nums[r] ^= nums[l];
        nums[l] ^= nums[r];
    }
}
