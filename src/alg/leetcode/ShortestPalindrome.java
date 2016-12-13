package alg.leetcode;

/**
 * Created by feng on 16/4/24.
 * <p>
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * For example:
 * <p>
 * Given "aacecaaa", return "aaacecaaa".
 * <p>
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("mississippi"));
        new StrStr();
    }

    public String shortestPalindrome(String s) {

        if (null == s || s.isEmpty()) {
            return s;
        }

        int i =0;
        int j = s.length();

        while (i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }

        return null;
    }
}
