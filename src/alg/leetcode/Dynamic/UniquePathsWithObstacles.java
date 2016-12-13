package alg.leetcode.Dynamic;

/**
 * Created by feng on 16/9/19.
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}};

        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(grid));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] r = new int[m][n];
        boolean hasObs = false;
        for(int i = 0; i < n; i++){
            if (obstacleGrid[0][i] == 1) hasObs = true;
            r[0][i] = obstacleGrid[0][i] == 1 || hasObs ? 0 : 1;
        }
        hasObs = false;
        for(int j = 0; j < m; j++){
            if (obstacleGrid[j][0] == 1) hasObs = true;
            r[j][0] = obstacleGrid[j][0] == 1 || hasObs ? 0 : 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    r[i][j] = 0;
                }else{
                    r[i][j] = r[i-1][j] + r[i][j-1];
                }
            }
        }

        return r[m - 1][n - 1];
    }
}
