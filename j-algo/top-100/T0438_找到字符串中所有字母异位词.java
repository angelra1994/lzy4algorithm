import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 438. 找到字符串中所有字母异位词
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-16.
 */
public class T0438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        T0438_找到字符串中所有字母异位词 t = new T0438_找到字符串中所有字母异位词();
        assertEquals(List.of(0, 6), t.findAnagrams("cbaebabacd", "abc"));
        assertEquals(List.of(0, 1,2), t.findAnagrams("abab", "ab"));

        assertEquals(List.of(0, 6), t.findAnagrams1("cbaebabacd", "abc"));
        assertEquals(List.of(0, 1,2), t.findAnagrams1("abab", "ab"));

    }

    // 定长滑窗
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntP = new int[26]; // 统计 p 的每种字母的出现次数
        int[] cntS = new int[26]; // 统计 s 的长为 p.length() 的子串 s' 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cntP[c - 'a']++;      // 统计 p 的每种字母出现的次数
        }
        for (int r = 0; r < s.length(); r++) {
            cntS[s.charAt(r) - 'a']++;
            int l = r - p.length() + 1;
            if (l < 0) {
                continue;
            }
            if (check(cntS, cntP)) {  // 窗口中字符出现的频次和p中字符出现的频次相同
                ans.add(l);
            }
            cntS[s.charAt(l) - 'a']--; // 左端点字母离开窗口
        }
        return ans;
    }

    private boolean check(int[] cntS, int[] cntP) {
        if (cntS==cntP) {
            return true;
        };
        if (cntS==null || cntP==null) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            if (cntS[i] != cntP[i]) {
                return false;
            }
        }
        return true;
    }


    // 不定长滑窗
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26]; // 统计每种字母出现的次数。p中出现的字符次数+1，窗口中出现这个字符次数-1
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r) - 'a';               // r位置的字符在cnt中的索引
            cnt[c]--;                                // 该字符出现的次数减1, 窗口中出现这个字符次数-1
            while (cnt[c] < 0) {                     // 如果 r[c] == 0。说明窗口中的该字符出现的次数等于p中该字符出现的次数
                cnt[s.charAt(l) - 'a']++;            // 左端点离开窗口, 把对应的计数复原
                l++;
            }
            if (r-l+1 == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }
}
