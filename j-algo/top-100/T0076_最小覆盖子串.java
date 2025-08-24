import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 76.最小覆盖子串
 * <a href="https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-20.
 */
public class T0076_最小覆盖子串 {
    public static void main(String[] args) {
        T0076_最小覆盖子串 t = new T0076_最小覆盖子串();
        assertEquals("BANC", t.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", t.minWindow("aa", "a"));
        assertEquals("", t.minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        // 统计子串和t中每一个字符出现频次
        int[] cntS = new int[128];
        int[] cntT = new int[128];

        for (char c: t.toCharArray()) {
            cntT[c]++;
        }
        int ansL = -1;
        int ansR = s.length();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cntS[s.charAt(r)]++;            // r位置的字符进入字串
            while (check(cntS, cntT)) {     // 判断子串是否满足要求
                if (r - l + 1 < ansR - ansL + 1) {
                    ansL = l;
                    ansR = r;
                }
                cntS[s.charAt(l)]--;         // l位置的字符离开字串
                l++;
            }
        }
        if (ansL == -1) {  // 没有进入check的循环，说明没有满足条件的字串
            return  "";
        }
        return s.substring(ansL, ansR + 1);

    }

    private boolean check(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
