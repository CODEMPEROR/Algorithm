package alg.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by feng on 2016/12/4.
 */
public class FrogJump {

    public static void main(String[] args) {
        System.out.println(new FrogJump().canCross(new int[]{0,1,2,3,4,5,10,12}));
    }

    public boolean canCross(int[] stones) {
        if(stones == null || stones.length <= 1){
            return true;
        }

        if(stones[0] != 0 || stones[1] != 1){
            return false;
        }
        //represent the step can move at stones[i]
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(stones.length);
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>() );
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }
        return false;
    }
}
