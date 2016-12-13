package alg.leetcode.Dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by feng on 16/9/25.
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSUm {


    public static void main(String[] args) {
        int[] c = new int[]{2, 3, 6, 7};
        System.out.println(new CombinationSUm().combinationSum(c, 7));
        ;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return r;
        }
        Arrays.sort(candidates);
        com(candidates, r, target, 0, null);
        return r;
    }

    private void com(int[] c, List<List<Integer>> r, int target, int p, List<Integer> item) {

        int len = c.length;

        if (item == null) {
            item = new ArrayList<>();
        }

        int cs = r.size();

        if (p >= len) {
            return;
        }

        if (target < c[p]) {
            return;
        } else if (target == c[p]) {
            item.add(c[p]);
            r.add(item);
            return;
        } else {
            item.add(c[p]);
            com(c, r, target - c[p], p, item);
        }

        List<Integer> next = new ArrayList<>(item);
        if (cs < next.size()) {
            next.remove(next.size() - 1);
        }
        com(c, r, target, p + 1, next);

    }
}
