package t02_2pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 42. 接雨水
 * <a href="https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-05.
 */
public class T0042 {
    public static void main(String[] args) {
        T0042 t = new T0042();

        assertEquals(6, t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9, t.trap(new int[]{4,2,0,3,2,5}));
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int sum = 0;

        while (l < r) {
            maxL = Math.max(maxL, height[l]);
            maxR = Math.max(maxR, height[r]);
            if (maxL < maxR) {
                sum += maxL - height[l];
                l++;
            } else {
                sum += maxR - height[r];
                r--;
            }
        }

        return sum;
    }
}
