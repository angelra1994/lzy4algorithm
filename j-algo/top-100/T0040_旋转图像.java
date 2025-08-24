import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 48. 旋转图像
 * <a href="https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-24.
 */
public class T0040_旋转图像 {
    public static void main(String[] args) {
        T0040_旋转图像 t = new T0040_旋转图像();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        t.rotate(matrix);
        assertTrue(Arrays.deepEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, matrix));

        /**
         *  1,2,3               7,4,1       1,2,3                 1,4,7            7,4,1
         *  4,5,6   -90度旋转->  8,5,2   =>  4,5,6 -左对角线(\)翻转-> 2,5,6 -左右翻转-> 6,5,4
         *  7,8,9               9,6,3       7,8,9                 1,2,9            8,5,2
         */
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        t.rotate1(matrix);
        assertTrue(Arrays.deepEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, matrix));

        /**
         *  1,2,3               9,8,7       1,2,3           3,2,1            9,8,7
         *  4,5,6   -180度旋转-> 6,5,4   =>  4,5,6 -左右翻转-> 6,5,4 -上下翻转-> 6,5,4
         *  7,8,9               3,2,1       7,8,9           9,8,7            3,2,1
         */
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        t.rotate180(matrix);
        assertTrue(Arrays.deepEquals(new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}, matrix));
    }


    /**
     * 顺时针旋转180度 (i,j) -> (n-1-i,n-1-j)
     * (i,j) -(行)Y轴左右翻转-> (i,n-1-j) -(列)X轴上下翻转-> (n-1-i,n-1-j)
     */
    public void rotate180(int[][] matrix) {
        // 1. 每一行的数据进行左右翻转
        // for (int[] row : matrix) {
        //     for (int i = 0; i < n / 2; i++) {
        //         tmp = row[i];
        //         row[i] = row[n - 1 - i];
        //         row[n - 1 - i] = tmp;
        //     }
        // }

        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        int tmp;
        // 1. 每一行的数据进行左右翻转
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }


        // 2. 每一列的数组进行上下翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    /**
     * 顺时针旋转90度 (i,j) -> (j,n-1-i)
     * (i,j) -左对角线(\)翻转-> (j,i) -Y轴左右翻转-> (j,n-1-i)
     * [a][b] -> [b][c] ，其中a+c = n-1
     */
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        // 1. 对角线旋转
        for (int i = 0; i < n; i++) {
            // 遍历对角线左下方元素，左下方和右上方交换
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 2. 每一行的数组进行左右翻转
        for (int[] row : matrix) {
            for (int i = 0; i < n / 2; i++) {
                int tmp = row[i];
                row[i] = row[n - 1 - i];
                row[n - 1 - i] = tmp;
            }
        }
    }

    /**
     * 类似螺旋矩阵思路，从外到内处理每一圈。使用四个边界作为while条件
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        // 边界信息
        int a = 0, b = n - 1;
        int tmp;
        while (a <= b) {
            // for表示完整的处理一圈, i代表从角开始第几个元素, 从0开始
            for (int i = 0; i < b - a; i++) {
                tmp = matrix[a][a + i];
                // 左上 <- 左下 <- 右下 <- 右上 <- tmp
                matrix[a][a + i] = matrix[b - i][a];
                matrix[b - i][a] = matrix[b][b - i];
                matrix[b][b - i] = matrix[a + i][b];
                matrix[a + i][b] = tmp;
            }
            a++;
            b--;
        }
    }
}
