package alg.leetcode;

import java.util.HashMap;

/**
 * Created by feng on 2016/10/25.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] ints = new TwoSum().twoSum(new int[]{1, 2, 4}, 6);
        System.out.println(ints[0] + "\t" + ints[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        int length = 0;
        int [] result = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();//
        for(int i = 0; i < nums.length; i++){
            int m = target - nums[i];
            if(map.containsKey(m)){
                result[0] = map.get(m);
                result[1] = i;
                return result;
            }else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
