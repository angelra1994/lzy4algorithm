import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 60. 不同路径 II
 * <a href="https://leetcode.cn/problems/unique-paths-ii/description/?envType=study-plan-v2&envId=dynamic-programming">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T0060 {
    public static void main(String[] args) {
        T0060 t = new T0060();
        assertEquals(2, t.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertEquals(1, t.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] != 0 || obstacleGrid[m - 1][n - 1] != 0) {
            return 0;
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;                 // [[0,1,0,0]] 堵住了
            }
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;                 // [[0],[1],[0],[0]] 堵住了
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
