import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 11. 盛最多水的容器
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-16.
 */
public class T0011_盛最多水的容器 {
    public static void main(String[] args) {
        T0011_盛最多水的容器 t = new T0011_盛最多水的容器();
        assertEquals(49, t.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(1, t.maxArea(new int[]{1, 1}));
    }
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }


}
