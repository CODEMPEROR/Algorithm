package alg.weissma.chapter1;

/**
 * Created by feng on 16/9/28.
 */
public class Permute {

    public static void main(String[] args) {
        new Permute().permute("abs");
    }


    private void permute(String s){
         permute(s.toCharArray(), 0, s.length());
    }


    private void permute(char[] s, int left, int right){


    }
}
