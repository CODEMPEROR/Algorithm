package alg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by feng on 2016/10/26.
 */
public class FindAllAnaGrams {

    public static void main(String[] args) {
        new FindAllAnaGrams().findAnagrams("abcabc", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return res;
        }
        int[] hash = new int[128];
        for(int i = 0; i < p.length(); i++){
            hash[p.charAt(i)]++;
        }

        int pLength = p.length();
        int begin = 0, end = 0;

        while(end < s.length()){
            if(hash[s.charAt(end++)]-- > 0) pLength--;
            if(pLength == 0) res.add(begin);
            if(p.length() == end - begin && hash[s.charAt(begin++)]++ >= 0) pLength++;
        }


        return res;
    }
}
