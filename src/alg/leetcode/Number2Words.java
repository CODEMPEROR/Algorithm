package alg.leetcode;

/**
 * Created by feng on 2016/11/29.
 */
public class Number2Words {

    public static void main(String[] args) {
        Number2Words number2Words = new Number2Words();
        String res = number2Words.numberToWords(1123123);
        System.out.printf(res);
    }

    public String numberToWords(int num) {
        String[] units = {"", "Hundred", "Thousand", "Million", "Billion"};
        String sb = new String();
        int tmp = 0, i = 0, j = 0;
        while(num > 0){
            tmp += pow(j) * (num % 10);
            j++;
            num = num / 10;
            if((i + 1) % 3 == 0 || num == 0){
                j = 0;
                System.out.println(tmp);
                sb = Bit2Eng(tmp) + units[i/3] + " " + sb;
                tmp = 0;
            }
            i++;
        }
        return sb.trim();
    }

    private int pow(int p){
        int res = 1;
        for(int i = 0; i < p; i++){
            res *= 10;
        }
        return res;
    }

    //将三位数字转为Eng
    private String Bit2Eng(int num){

        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] t = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder sb = new StringBuilder();
        int unit = num % 10;
        int decade = (num / 10) % 10;
        int hundred = (num / 100);
        if(hundred > 0) sb.append(ones[hundred] + " Hundred ");
        if(decade >= 2) {
            sb.append(t[decade - 2] + " " + ones[unit]);
        }else if(decade > 0 ) {
            sb.append(tens[unit]);
        } else if (decade == 0){
            sb.append(ones[unit]);
        }
        return sb.toString();
    }

}
