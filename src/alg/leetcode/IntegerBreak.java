package alg.leetcode;

/**
 * Created by feng on 16/4/24.
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(8));
    }

    public int integerBreak(int n) {

        if (n == 2) {
            return n;
        }

        if (n == 3) {
            return 2;
        }

        if (n % 3 == 1) return (int) Math.pow(3, (n - 4) / 3) * 4;
        if (n % 3 == 2) return (int) Math.pow(3, (n - 2) / 3) * 2;
        return (int) Math.pow(3, n / 3);
    }
}
