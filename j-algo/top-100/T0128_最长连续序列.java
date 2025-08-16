import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 128.最长连续序列
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-16.
 */
public class T0128_最长连续序列 {

    public static void main(String[] args) {
        T0128_最长连续序列 t = new T0128_最长连续序列();
        assertEquals(4, t.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        int ans =  0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (Integer num : set) {
            // 如果num-1 不在集合中，说明num是连续序列的起始点
            if (!set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num+len))  {
                    len++;
                }
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
