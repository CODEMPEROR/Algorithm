package alg.leetcode;

/**
 * Created by feng on 16/4/23.
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {


        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        return haystack.indexOf(needle);

        /*for (int i = 0; i < haystack.length();) {
            int index = i;
            int j;
            for (j = 0; j < needle.length() && i < haystack.length();) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else {
                    break;
                }
            }

            if (j == needle.length()) {
                return index;
            }
            i = index + 1;
        }

        return -1;
*/
    }


    public int strStr1(String haystack, String needle) {


        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        int hl = haystack.length();
        int nl = needle.length();

        for (int i = 0; i < hl - nl + 1; i++){

            int count = 0;

            while (count < nl && haystack.charAt(i + count) == needle.charAt(count))
                count++;

            if (count == nl){
                return i;
            }
        }

        return -1;

    }



}
