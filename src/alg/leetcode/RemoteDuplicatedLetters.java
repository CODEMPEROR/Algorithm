package alg.leetcode;

import java.util.Stack;

/**
 * Created by feng on 2016/12/10.
 */
public class RemoteDuplicatedLetters {

    public static void main(String[] args) {
        System.out.println(new RemoteDuplicatedLetters().removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {

        if (null == s || s.length() == 0) return s;
        //the count of c
        int[] hash = new int[26];
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
            visited[c - 'a'] = false;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            hash[c - 'a']--;
            if (visited[c - 'a']) continue;
            //hash[stack.peek()-'a'] is to check if there are more c after this one.
            while (!stack.isEmpty() && stack.peek() > c && hash[stack.peek() - 'a'] > 0) {
                //you get a chance to become smaller
                char p = stack.pop();
                visited[p - 'a'] = false;
                System.out.println(p);
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        Runnable r = ()-> {
            System.out.printf("go");

        };


        stack.forEach(sb::append);
        return sb.toString();
    }
}
