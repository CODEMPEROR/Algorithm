package alg.weissma.chapter1;

/**
 * Created by feng on 16/9/28.
 * 计算n中1的个数
 */
public class CountByte1 {

    public static void main(String[] args) {
        int r = new CountByte1().count(181273872);
        int r1 = new CountByte1().countR(181273872);
        System.out.printf("while:" + r);
        System.out.println("recursion:" + r1);
    }

    private int count(int n){
        int count = 0;

        while (n > 0){
            if ((n & 1) == 1){
                count++;

            }
            n >>= 1;
        }
        return count;
    }


    private int countR(int n){

        if (n == 0){
            return 0;
        }

        int c = 0;
        if ((n & 1) == 1){
            c  = 1;
        }

        return countR(n >> 1) + c;
    }
}
