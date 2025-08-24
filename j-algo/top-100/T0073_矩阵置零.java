import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 73. 矩阵置零
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-23.
 */
public class T0073_矩阵置零 {
    public static void main(String[] args) {
        T0073_矩阵置零 t = new T0073_矩阵置零();
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] ans = new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        t.setZeroes1(matrix);
        assertTrue(Arrays.deepEquals(ans, matrix));

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        ans = new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        t.setZeroes(matrix);
        assertTrue(Arrays.deepEquals(ans, matrix));
    }

    // 额外的空间复杂度为O(1)。利用第一行、第一列作为标志位，matrix[i][j] = 0 -> matrix[0][j] = matrix[i][0] = 0;。
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 暴力解法，额外的空间复杂度为O(m*n)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] traveled = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!traveled[i][j] && matrix[i][j] == 0) {
                    traveled[i][j] = true;
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0) {
                            traveled[k][j] = true;
                            matrix[k][j] = 0;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            traveled[i][k] = true;
                            matrix[i][k] = 0;
                        }
                    }
                }
            }
        }
    }
}
