import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 3.无重复字符的最长子串
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-09.
 */
public class T0003_无重复字符的最长子串 {
    public static void main(String[] args) {
        T0003_无重复字符的最长子串 t = new T0003_无重复字符的最长子串();
        String s = "pwwkew";
        assertEquals(3, t.lengthOfLongestSubstring(s));
    }

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        // 二重循环，a为滑动窗口的左边界，b为右边界。
        int b = 0, n = s.length(), ans = 0;
        for (int a = 0; a < n; a++) {
            if (a != 0) {
                set.remove(s.charAt(a-1));
            }
            // 左闭右开
            while (b < n && !set.contains(s.charAt(b))) {
                set.add(s.charAt(b));
                b++;
            }
            ans = Math.max(ans, b - a);
        }
        return ans;
    }
}
