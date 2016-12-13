package alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 16/9/13.
 */
public class Integer2Roman {
    public static void main(String[] args) {


        int num = 100;

        if(num < 1 || num > 3999){
            return;
        }

        List<String> res  = new ArrayList<>();
        int wei = 1;

        while(num > 0){
            int current = (num % 10) * wei;

            res.add(intTo(current, wei));

            wei *= 10;
            num /= 10;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = res.size() - 1; i >= 0; i--){
            sb.append(res.get(i));
        }

        System.out.println(sb.toString());
    }

    private static String intTo(int num, int wei){
        String res = null;
        if(wei == 1){
            res = getChar(num, 'I', 'V', 'X');
        }else if(wei == 10){
            res = getChar(num / wei, 'X', 'L', 'C');
        }else if(wei == 100){
            res = getChar(num/wei, 'C', 'D', 'M');
        }else {
            res = getChar(num/wei, 'M','M','M');
        }

        return res;
    }

    private static String getChar(int num, char min, char max, char larger){
        StringBuffer sb = new StringBuffer();

        if(num == 9){
            sb.append(min);
            sb.append(larger);

        }else if(num >= 5 && num <= 8){

            sb.append(max);
            int count = num - 5;
            while(count-- > 0){
                sb.append(min);

            }
        }else if(num == 4){
            sb.append(min);
            sb.append(max);
        }else if(num <= 3 && num >= 1){
            int count = num - 1;
            while(count-- >= 0){
                sb.append(min);

            }
        }

        return sb.toString();
    }
}
