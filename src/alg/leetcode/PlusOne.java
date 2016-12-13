package alg.leetcode;

/**
 * Created by feng on 16/9/12.
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] res= plusOne(new int[]{9,9,9});

        for (int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

    public static int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return digits;
        }

        int len = digits.length;

        for(int i = len - 1; i >= 0; i--){
                digits[i] += 1;

                if(digits[i] < 10){
                    return digits;
                }else{
                    digits[i] = 0;
                }
        }

        if(digits[0] == 0){
            digits[0] = 0;
            int[] res = new int[len + 1];
            res[0] = 1;
            for(int j = 1; j < res.length; j++){
                res[j] = digits[j - 1];
            }
            return res;
        }


        return digits;
    }
}
