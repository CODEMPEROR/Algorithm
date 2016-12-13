package alg.leetcode;

import java.util.Arrays;

/**
 * Created by feng on 16/9/15.
 * https://leetcode.com/problems/contains-duplicate/
 *
 * TIME-LIMIT-OUT
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        Arrays.stream(args).distinct().count();

        int[] nums = new int[30000];

        for (int i = 0; i < nums.length; i++){
            nums[i] = i;
        }

        if(nums == null || nums.length == 0){
            System.out.println(false);
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(findIt(nums, nums[i], i + 1, nums.length - 1)){
                System.out.println(true);
            }
        }

        System.out.println(false);
    }

    private static boolean findIt(int[] nums, int current, int left, int right){

        if (left >= right){
            return false;
        }

        int mid = (left + right) / 2;
        if(current == nums[mid]){
            return true;
        }

        return findIt(nums, current, left, mid - 1) || findIt(nums, current, mid + 1, right);
    }
}
