package alg.leetcode.Dynamic;

/**
 * Created by feng on 16/9/21.
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int en[][] = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.printf(new RussianDollEnvelopes().maxEnvelopes(en) + "");
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        return 0;
    }
}
