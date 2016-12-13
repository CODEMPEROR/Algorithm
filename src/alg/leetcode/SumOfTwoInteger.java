package alg.leetcode;

/**
 * Created by feng on 2016/10/25.
 */
public class SumOfTwoInteger {

    public static void main(String[] args) {
        System.out.println(new SumOfTwoInteger().getSum(100,2));
    }

    public int getSum(int a, int b) {
        int pre = 0;
        int sum = 0;
        for(int i = 0; i < 32; i++){
            int aa = (a >> i) & 1;
            int bb = (b >> i) & 1;
            if(((aa ^ bb) == 0) && aa == 1){
                //aa 和bb都为1，则要进位
                if(pre == 1){
                    sum += (1 << i);
                }
                pre = 1;
            }else if ((aa ^ bb) == 1){
                if(pre == 0){
                    sum += (1 << i);
                }
            }else {
                if (pre == 1){
                    sum += (1 << i);
                }
                pre = 0;
            }
        }

        return sum;
    }
}
