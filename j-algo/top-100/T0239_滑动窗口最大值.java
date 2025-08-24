import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 239. 滑动窗口最大值
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-17.
 */
public class T0239_滑动窗口最大值 {
    public static void main(String[] args) {
        T0239_滑动窗口最大值 t = new T0239_滑动窗口最大值();
        int[] ans = t.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        assertEquals(3, ans[0]);
        assertEquals(3, ans[1]);
        assertEquals(7, ans[5]);
    }

    //如果新员工比老员工强（或者一样强），把老员工裁掉。（元素进入窗口）
    //如果老员工 35 岁了，也裁掉。（元素离开窗口）
    //裁员后，资历最老（最左边）的人就是最强的员工了。
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];  // 有（n - k + 1）个长度为k的窗口
        int[] q = new int[n];            // 用数组q模拟一个单调队列,
        int head = 0;                    // q[head]为队头记录了当前窗口中最大元素的位置
        int tail = -1;                   // q[tail]为队尾记录了当前窗口中最小元素的位置
        for (int i = 0; i < n; i++) {
            // 1. 右边进，往左移动，直到q[tail] > nums[i]
            while (head <= tail && nums[q[tail]] <= nums[i]) {
                tail--;
            }
            tail++;
            q[tail] = i; // 右边入队

            // 2. 左边出
            int left = i - k + 1;  // 当前滑动窗口的左边界
            if (q[head] < left) {  // 队头元素不在滑动窗口内，已经滑出窗口的左边界了
                head++;
            }

            // 3. 记录答案 (在窗口左端点)
            if (left >= 0) {
                // 由于队首到队尾单调递减，队首记录了窗口最大值的位置
                ans[left] = nums[q[head]];
            }

        }
        return ans;
    }
}
