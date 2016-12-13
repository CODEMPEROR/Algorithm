package alg.leetcode;

/**
 * Created by feng on 2016/10/27.
 * Sling window.
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.printf(new LongestSubstring().longestSubstringAtMost2("ababaaca") + "");
    }

    public int longestSubstringAtMost2(String s) {
        int[] hash = new int[128];
        int begin = 0, end = 0, counter = 0, len = 0;

        while (end < s.length()) {
            if (hash[s.charAt(end++)]++ == 2) counter++;
            while (counter == 1) if (hash[s.charAt(begin++)]-- == 3) counter--;
            len = Math.max(len, end - begin);
        }
        return len;
    }

    public int longestSubstringAtMostKDistinct(String s, int k) {
        int hash[] = new int[128];
        int begin = 0, end = 0, counter = 0, len = 0;

        while (end < s.length()) {
            if (hash[s.charAt(end++)]++ == k) counter++;
            while (counter == 1) {
                if (hash[s.charAt(begin++)]-- == k + 1) counter--;
            }
            len = Math.max(len, end - begin);
        }
        return len;
    }

    public int longestSubstrngAtLeastKDistinct(String s, int k) {
        int[] hash = new int[128];
        int begin = 0, end = 0, counter = 0, len = 0;

        while (end < s.length()) {
            if (hash[s.charAt(end++)]++ > k - 1) counter++;
        }

        return 1;
    }


    public int longestSubstring(String s) {

        int[] hash = new int[128];
        int begin = 0, end = 0, counter = 0, len = 0;

        while (end < s.length()) {
            if (hash[s.charAt(end++)]++ == 1) counter++;
            while (counter == 1) {
                if (hash[s.charAt(begin++)]-- == 2) counter--;
            }
            len = Math.max(len, end - begin);
        }

        return len;
    }
}
