package alg.leetcode;

/**
 * Created by feng on 16/9/12.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicated {

    public static void main(String[] args) {
        int[] nums = new int[32];
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int i = 0;
        for(int n : nums){
            if(i == 0 || nums[i - 1] < n ){
                nums[i++] = n;
            }
        }

        return i;
    }
}
