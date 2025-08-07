import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 32.最长有效括号
 * <a href="https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-07.
 */
public class T0032 {
    public static void main(String[] args) {
        T0032 t = new T0032();

        assertEquals(2, t.longestValidParentheses("(()"));
        assertEquals(6, t.longestValidParentheses("(()())"));
        assertEquals(4, t.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        if (null == s || s.length() < 2) {
            return ans;
        }

        // dp[i] 表示 s[0...i] 中最长有效括号长度。i位置为'('标记长度为0
        int[] dp = new int[s.length()];

        int left = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                left = i - dp[i-1] - 1;     // 找到可能会和 s.charAt(i) 匹配的 '(' 位置
                if (left >= 0 && s.charAt(left) == '(') {
                    // 当前有效长度 = 前一个有效长度 + 2（当前匹配对） + left前一段的有效长度
                    if (left > 0) {
                        dp[i] = dp[i - 1] + 2 + dp[left - 1];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
