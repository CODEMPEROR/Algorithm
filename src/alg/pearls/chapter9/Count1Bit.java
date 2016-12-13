package alg.pearls.chapter9;

import java.util.HashMap;

/**
 * Created by feng on 2016/12/13.
 * Count 1 bit in a long long number(billion bit or more).
 */
public class Count1Bit {
    static HashMap<Integer, Integer> bitCache = new HashMap<>();

    public static void main(String[] args) {
        Count1Bit cb = new Count1Bit();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            bitCache.put(i, cb.count1Num(i));
        }
        long end = System.nanoTime();

        System.out.println("last Time: " + (Integer.MAX_VALUE / 1000/ 1000/ 1000) * (end - start) / 1000+ "s");
        System.out.println(cb.count(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    /**
     * 首先使用高速缓存保存每个32个整数中1的个数, 然后计算每个数值出现的次数,然后进行统计.
     * <p>
     *
     * @param nums
     * @return
     */
    private int count(int[] nums) {

        int count = 0;
        for (int n : nums) {
            count += bitCache.get(n);
        }
        return count;
    }

    /**
     * 如何计算32为整数中1的个数: b &= b - 1
     * b - 1 将使n中的最后一个1消失
     *
     * @param n
     * @return
     */
    private int count1Num(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);// 操作之后,n的最后一位1消失
            count++;
        }
        return count;
    }

}
