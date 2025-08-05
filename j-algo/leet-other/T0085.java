import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 85.最大矩形
 * <a href="https://leetcode.cn/problems/maximal-rectangle/description/">...</a>
 * Created by lzy on 2025-08-04.
 */
public class T0085 {
    public static void main(String[] args) {
        T0085 t = new T0085();

        assertEquals(6, t.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // left[i][j] 表示第i行第j列向左连续1的个数, 表示以 i,j为右下角的矩形的横向长度
        int[][] left = new int[m][n];
        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 定位右下角
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        left[i][j] = 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                    // 向上扩展，计算以当前位置为右下角的最大矩形
                    int width = left[i][j];
                    for (int k = i; k >= 0 && matrix[k][j] == '1'; k--) {
                        width = Math.min(width, left[k][j]);
                        // 纵向连续'1'的高度
                        int height = i - k + 1;
                        area = Math.max(area, width * height);
                    }
                }
            }
        }

        return area;
    }
}
