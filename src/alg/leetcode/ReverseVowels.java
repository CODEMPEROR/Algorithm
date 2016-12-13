package alg.leetcode;

/**
 * Created by feng on 16/4/23.
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "alg.leetcode", return "leotcede".
 */
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("hello"));
    }


    public String reverseVowels(String s) {

        if (s != null && !s.isEmpty()) {

            char[] res = s.toCharArray();

            int i, j;
            for (i = 0, j = s.length() - 1; i < j; ) {
                if (isVowels(s.charAt(i)) && isVowels(s.charAt(j))) {
                        res[i] ^= res[j];
                        res[j] ^= res[i];
                        res[i] ^= res[j];
                    i++;
                    j--;
                }else if (!isVowels(s.charAt(i)) && isVowels(s.charAt(j))){
                    i++;
                }else if (isVowels(s.charAt(i)) && !isVowels(s.charAt(j))){
                    j--;
                }
                else {
                    i++;
                    j--;
                }


            }

            return new String(res);
        }

        return s;
    }

    private boolean isVowels(Character character) {
        character = Character.toLowerCase(character);
        if (character == 'a' || character == 'e' || character == 'i'
                || character == 'o' || character == 'u') {
            return true;
        }

        return false;
    }
}
