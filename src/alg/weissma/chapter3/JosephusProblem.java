package alg.weissma.chapter3;

/**
 * Created by feng on 16/10/5.
 */
public class JosephusProblem {

    public static void main(String[] args) {
        new JosephusProblem().josephus(100, 1);
        new JosephusProblem().josephusRec(100, 1);
    }

    private void josephus(int n, int m) {

        int k = 0;
        int i = 2;
        while (i <= n) {
            k = (k + m) % n;
            i++;
        }

        System.out.printf("res = " + k);

    }


    private void josephusRec(int n, int m) {
        int s = 0;
        for (int i = 2; i <= n; i++)
            s = (s + m) % i;

        System.out.printf("res_rec = " + s);
    }

}
