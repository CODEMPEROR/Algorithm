package alg.leetcode;

/**
 * Created by feng on 2016/12/13.
 * <p>
 * 二叉搜索
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 2};
        int t = 2;
        int l = 0;
        int u = nums.length - 1;
        BinarySearch bs = new BinarySearch();
        System.out.println("Normal Binary Search: " + bs.binSearch(nums, l, u, t));
        System.out.println("First Binary Search: " + bs.binSearchFirst(nums, l, u, t));
        System.out.println("Last Binary Search: " + bs.binarySearchLast(nums, l, u, t));
    }


    /**
     * normal binary search for sorted array.
     *
     * @param nums sorted array
     * @param l    low
     * @param u    up
     * @param t    target
     * @return index of t in this array if exist, otherwise -1
     */
    private int binSearch(int[] nums, int l, int u, int t) {
        int mid, cur;
        while (l <= u) { // care for '='
            mid = l + ((u - l) >> 1);
            cur = nums[mid];
            if (t == cur) {
                return mid;
            } else if (t < cur) {
                u = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * find the first element which equals to t
     *
     * @param nums sorted array
     * @param l    low
     * @param u    up
     * @param t    target
     * @return return index if exist, otherwise -1
     */
    private int binSearchFirst(int[] nums, int l, int u, int t) {
        int mid;
        while (l < u) { // just <, no =
            mid = (l + u) >> 1;
            if (t > nums[mid]) {
                l = mid + 1;
            } else {
                u = mid;
            }
        }

        if (t == nums[l]) { // check
            return l;
        }
        return -1;
    }

    /**
     * find the last element which equals to t
     *
     * @param nums sorted array
     * @param l    low
     * @param u    up
     * @param t    target
     * @return return index if exist, otherwise -1
     */
    private int binarySearchLast(int[] nums, int l, int u, int t) {
        int mid;
        while (l + 1 < u) { // care for this condition
            mid = l + ((u - l) >> 1);
            if (t >= nums[mid]) {
                l = mid;
            } else {
                u = mid - 1;
            }
        }

        if (nums[u] == t) {
            return u;
        }
        if (nums[l] == t) {
            return l;
        }
        return -1;
    }
}
