package alg.leetcode;

/**
 * Created by feng on 16/5/4.
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("ecbacdcbc"));
    }


    public String removeDuplicateLetters(String s) {

        if (null == s || s.length() == 0) {
            return s;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index;
            if ((index = sb.indexOf(c + "")) >= 0) {
                String ori = sb.toString();
                StringBuffer oriSb = new StringBuffer(ori);

                String aft = oriSb.deleteCharAt(index).append(c).toString();

                if (aft.compareTo(ori) < 0) {
                    sb.deleteCharAt(index);
                    sb.append(c);

                }
            } else {
                sb.append(c);
            }
        }


        return sb.toString();
    }
}
