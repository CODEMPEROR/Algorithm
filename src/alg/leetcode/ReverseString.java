package alg.leetcode;

/**
 * Created by feng on 16/4/23.
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {


    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("hello"));
    }


    public String reverseString(String s) {

        if (s != null && !s.isEmpty()) {

            char[] res = s.toCharArray();

            int i, j;
            for (i = 0, j = s.length() - 1; i < j; ) {
                res[i] ^= res[j];
                res[j] ^= res[i];
                res[i] ^= res[j];
                i++;
                j--;
            }

            return new String(res);
        }

        return s;
    }

}
