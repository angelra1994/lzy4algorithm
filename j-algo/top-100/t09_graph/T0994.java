package t09_graph;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 994.腐烂的橘子
 * <a href="https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-05.
 */
public class T0994 {
    public static void main(String[] args) {

        T0994 t = new T0994();
        assertEquals(4, t.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

    // BFS 利用队列先入先出实现 BFS
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0, fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    // 腐烂的橘子入队
                    q.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            // 遍历当前时刻的所有腐烂的橘子
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for(int[] dir: dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    // 判断腐烂橘子的四周是否在范围内，是否是新鲜橘子
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                        continue;
                    }
                    grid[x][y] = 2;  // 被感染的橘子
                    q.offer(new int[]{x, y});
                    fresh--;
                }
            }
            time++;
        }
        if (fresh > 0) {
            return -1;
        } else {
            return time;
        }
    }
}
