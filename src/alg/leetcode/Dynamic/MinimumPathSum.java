package alg.leetcode.Dynamic;

/**
 * Created by feng on 16/9/19.
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {


    public static void main(String[] args) {

        int[][] grid = new int[][]{{8, 6, 2}, {9, 3, 8}, {6, 2, 9}};

        System.out.println(new MinimumPathSum().minPathSum(grid));

    }

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int left, top;
        int i, j = 0;
        for (i = 0; i < grid.length; i++) {

            for (j = 0; j < grid[i].length; j++) {
                top = i == 0 ? 0 : grid[i - 1][j];
                left = j == 0 ? 0 : grid[i][j - 1];
                grid[i][j] = i == 0 ? grid[i][j] + left : j == 0 ? grid[i][j] + top : Math.min(left, top) + grid[i][j];
            }
        }

        return grid[i - 1][j - 1];

    }
}
