package alg.leetcode;

/**
 * Created by feng on 2016/12/8.
 */
public class String2Integer {

    public static void main(String[] args) {
        System.out.println(new String2Integer().myAtoi("2147483649"));
    }

    public int myAtoi(String str) {
        if (null == str || str.trim().length() == 0) return 0;
        int res = 0;
        str = str.trim();
        int sign = str.charAt(0) == '-' ? 1 : str.charAt(0) == '+' ? 1 : 0;

        for (int i = sign; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int tmp = res * 10;
                int cur = str.charAt(i) - '0';
                if (tmp / 10 != res || (tmp + cur) < tmp) {
                    return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = tmp + cur;

            } else {
                break;
            }
        }

        return str.charAt(0) == '-' ? 0 - res : res;
    }
}
