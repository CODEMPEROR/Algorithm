package alg.leetcode;

/**
 * Created by feng on 2016/11/3.
 */
public class IncreasingSubsequence {

    public static void main(String[] args) {
        IncreasingSubsequence increasingSubsequence = new IncreasingSubsequence();
        increasingSubsequence.increasingTriplet(new int[]{5,1,5,5,2,5,4});
    }

    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int start = 0, end = 1, count = 0;
        int lastNum = 0;
        while(end < nums.length){
            if(nums[end] > nums[lastNum]){
                lastNum = end;
                count++;
            }else {
                if (nums[end] <= nums[start]){
                    start = end;
                    lastNum = end;
                }else{
                    lastNum = end;
                }
                System.out.print(nums[start] + "\t" + nums[lastNum] + "\n");
            }
            end++;
            if(count == 3) return true;
        }
        return false;
    }
}
