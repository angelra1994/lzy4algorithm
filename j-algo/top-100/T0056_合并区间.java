import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 56. 合并区间
 * <a href="https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-23.
 */
public class T0056_合并区间 {
    public static void main(String[] args) {
        T0056_合并区间 t = new T0056_合并区间();
        // new int[][]{{1,6},{8,10},{15,28}}, t.merge(new int[][]{{1,3}, {2,6},{8,10},{15,28}})
        assertTrue(Arrays.deepEquals(new int[][]{{1,6},{8,10},{15,28}}, t.merge(new int[][]{{1,3}, {2,6},{8,10},{15,28}})));
    }

    public int[][] merge(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 让intervals数组按照p[0] 左端点升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        //两个区间 [a, b] 和 [c, d] 重叠的完整数学条件是：
        //a ≤ d（第一个区间的起点 ≤ 第二个区间的终点）
        //c ≤ b（第二个区间的起点 ≤ 第一个区间的终点）。 按照左端点排序后，只需要关注（第二个区间的起点 ≤ 第一个区间的终点）
        List<int[]> ans = new ArrayList<>();
        for(int[] x:  intervals) {
            int m = ans.size();
            if (m>0 && x[0] <= ans.get(m - 1)[1]) { // （第二个区间的起点 ≤ 第一个区间的终点）
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], x[1]);
            } else {
                ans.add(x);
            }

//            if (m == 0 || x[0] > ans.get(m - 1)[1]) { // x 和 ans.get(m - 1) 没有重合部分
//                ans.add(x);
//            } else {
//                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], x[1]);
//            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
