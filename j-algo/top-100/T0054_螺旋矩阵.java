import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 54. 螺旋矩阵
 * <a href="https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-23.
 */
public class T0054_螺旋矩阵 {

    public static void main(String[] args) {
        T0054_螺旋矩阵 t = new T0054_螺旋矩阵();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5), t.spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), t.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        // 边界信息
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            //  从左到右遍历上边界
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; // 上边界下移

            //  从上到下遍历右边界
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; // 右边界左移

            // 从右往左遍历下边界（如果还有行: 此时top值已经发生变化，需要重新校验 top <= bottom）
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--; // 下边界上移
            }

            // 从下到上遍历左边界（如果还有列: 此时right值已经发生变化，需要重新校验 left <= right）
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;  // 左边界右移
            }
        }
        return ans;
    }
}
