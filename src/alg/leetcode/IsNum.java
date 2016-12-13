package alg.leetcode;

/**
 * Created by feng on 2016/12/8.
 */
public class IsNum {

    public static void main(String[] args) {
        double a = +-.1;
        System.out.println(new IsNum().isNumber(" 005047e+6"));
    }

    public boolean isNumber(String s) {
        if(null == s || s.trim().length() == 0 ) return false;
        boolean e = false, dot = false, num = false;
        s = s.trim();
        int sign = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        if(s.charAt(0) == 'e' || s.charAt(s.length() - 1) == 'e') return false;
        for (int i = sign; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'e') {
                if(e || (i > 0 && s.charAt(i-1) == '.' && !num) || !num) return false;
                e = true;
            }else if (c == '.'){
                if(dot || e || s.length() == 1 || s.length() == 2 && sign == 1) return false;
                dot = true;
            }else if(c > '9' || c < '0'){
                if(e && (c == '-' || c == '+') && i == s.length() - 1 || (i > 0 && s.charAt(i-1) == c )){
                    return false;
                }
            }else {
                num = true;
            }
        }

        return true;
    }
}
