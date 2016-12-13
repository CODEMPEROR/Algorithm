package alg.leetcode;

import java.util.*;

/**
 * Created by feng on 2016/10/20.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println("///".split("/")[0]);

        new SimplifyPath().simplifyPath("/home/");


    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() <= 1) {
            return path;
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(".", ".."));

        Stack<String> stack = new Stack<>();
        int i = 1;
        StringBuffer sb = new StringBuffer();
        sb.append(path.charAt(0));
        while (i < path.length()) {
            char c = path.charAt(i);
            if (c == '/') {

                replace(stack, sb);
                sb.delete(0, sb.length());
                sb.append("/");
                if (i == path.length() - 1 && stack.isEmpty()) {
                    replace(stack, sb);
                }
            } else if (i == path.length() - 1) {
                sb.append(c);
                replace(stack, sb);
            } else {
                sb.append(c);
            }


            i++;
        }
        if (stack.size() > 0) {
            String[] strs = new String[stack.size()];
            stack.copyInto(strs);
            StringBuffer res = new StringBuffer();
            for (String str : strs) {
                res.append(str);
            }
            if (res.charAt(res.length() - 1) == '/') {
                //res.delete(res.length() - 1, res.length());
            }
            return res.toString();
        } else {
            return "";
        }
    }

    private void replace(Stack<String> stack, StringBuffer sb) {
        String str = sb.toString();
        if (str.equals("/..") && !stack.isEmpty()) {
            stack.pop();
        } else if (!str.equals("/.") && !str.equals("/..")) {
            stack.push(str);
        }
    }
}
