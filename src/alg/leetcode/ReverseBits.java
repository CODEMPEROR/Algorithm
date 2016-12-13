package alg.leetcode;

/**
 * Created by feng on 2016/10/25.
 */
public class ReverseBits {

    public static void main(String[] args) {

        System.out.printf(new ReverseBits().reverse(1) + "");
    }


    public int reverse(int n){
        int res = 0;
        for (int i = 0; i < 32; i++){
            res <<= 1;
            res += (n & 1);
            n = n >>> 1;
        }

        return res;
    }
}
