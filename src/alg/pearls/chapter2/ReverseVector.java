package alg.pearls.chapter2;

import java.util.Arrays;

/**
 * Created by feng on 2016/12/10.
 */
public class ReverseVector {

    public static void main(String[] args) {
        new ReverseVector().reverseVector2("abcdefghijklmn".toCharArray(), 3);
        new ReverseVector().gcd(12, 5);
    }

    /**
     *
     * @param vec
     * @param loop_num
     */
    private void reverseVector2(char[] vec, int loop_num) {
        int i = 0, j = 0;
        char temp;
        int len = vec.length;
        int d = gcd(len, loop_num);
        while (d-- > 0) {
            temp = vec[i];
            while ((i + loop_num) % len != j) {
                vec[i] = vec[(i + loop_num) % len];
                i = (i + loop_num) % len;
            }
            vec[i] = temp;
            j++;
            i = j;
            d--;
        }
        Arrays.asList(vec).forEach(System.out::print);
    }

    private int gcd(int i, int j) {

        while (j != 0) {
            int tmp = i % j;
            i = j;
            j = tmp;
        }
        System.out.print(i);
        return i;
    }

    /**
     * vec could be divided to two parts, a and b. (a'b')'=(ba). ' represents reverse operation.
     *
     * @param vec
     * @return
     */
    private void reverseVector(char[] vec, int i) {
        reverse(vec, 0, i);
        reverse(vec, i + 1, vec.length - 1);
        reverse(vec, 0, vec.length - 1);
        Arrays.asList(vec).forEach(System.out::print);
    }


    private void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[start];
            chs[start++] = chs[end];
            chs[end--] = tmp;
        }
    }
}
