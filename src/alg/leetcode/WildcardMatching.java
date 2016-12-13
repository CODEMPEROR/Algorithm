package alg.leetcode;

/**
 * Created by feng on 2016/12/9.
 */
public class WildcardMatching {

    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        if (null == s || null == p) return false;
        String[] pm = p.split("\\*");
        int prev = -1;
        for (int i = 0; i < pm.length; i++) {
            int begin = s.indexOf(pm[i]);
            if (begin < prev) return false;
            s = s.substring(begin + pm[i].length(), s.length());
        }
        return true;
    }
}
