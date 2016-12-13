package alg.leetcode;

/**
 * Created by feng on 16/9/13.
 */
public class ValidPalindrome {
    public static void main(String[] args) {


        String s = "A man, a plan, a canal: Panamaa";
        if(s == null || s.length() == 0){
            return;
        }

        char[] chars = s.toUpperCase().toCharArray();

        for(int i = 0, j = chars.length - 1; i < j; ){
            if(!isAlphanumberic(chars[i]) || !isAlphanumberic(chars[j])){
                if(!isAlphanumberic(chars[i])){
                    i++;
                }
                if(!isAlphanumberic(chars[j])){
                    j--;
                }
                continue;
            }

            if(chars[i++] != chars[j--]){
                System.out.println("false");
                return;
            }


        }
        System.out.println("true");

    }

    private static boolean isAlphanumberic(char c){
        boolean res =  c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
        return res;
    }


}
