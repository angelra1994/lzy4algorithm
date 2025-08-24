import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 240. 搜索二维矩阵 II
 * <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-24.
 */
public class T0240_搜索二维矩阵II {
    public static void main(String[] args) {
        T0240_搜索二维矩阵II t = new T0240_搜索二维矩阵II();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        assertTrue(t.searchMatrix(matrix, 5));
        assertTrue(t.searchMatrix1(matrix, 5));
        assertFalse(t.searchMatrix(matrix, 20));
        assertFalse(t.searchMatrix(matrix, 20));

    }

    /**
     * 利用从左到右，从上到下。都是有序的特征。
     * 从右上角开始和target比较
     * 右上角比target大的，则往左找
     * 右上角比target小的，则往下找
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            // 1. 右上角和target一样大，找到了
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {// 2. 右上角比target大，则往左找
                j--;
            } else { // 3. 右上角比target小，则往下找
                i++;
            }
        }
        return false;
    }

    // 每一行都去做二分查找，但是会计算多余的行
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        for (int[] row : matrix) {
            int index = binarySearch(row, target);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
