import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * brief: 139.单词拆分
 * <a href="https://leetcode.cn/problems/word-break/description/">...</a>
 * Created by lzy on 2025-08-03.
 */
public class T0139 {
    public static void main(String[] args) {
        T0139 t = new T0139();

        String s = "123456";
        System.out.println("s.substring(0, 3) = " + s.substring(0, 3));
        System.out.println("s.substring(0, 0) = " + s.substring(0, 0));
        System.out.println("s.substring(3, 6) = " + s.substring(3, 6));


        assertTrue(t.wordBreak("leetcode", List.of("leet", "code")));
        assertTrue(t.wordBreak1("leetcode", List.of("leet", "code")));
        assertTrue(t.wordBreak("applepenapple", List.of("apple", "pen")));
        assertTrue(t.wordBreak1("applepenapple", List.of("apple", "pen")));
        assertFalse(t.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        assertFalse(t.wordBreak1("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    private boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //int m = wordDict.size();
        int l = 0;
        boolean[] dp = new boolean[n + 1];     // 通过字符串列表拼接出前i个字符串，则dp[i] 为true
        dp[0] = true;
        for(int i = 1; i<= n; i++) {           // s中前i个字符构成的字符串和
            for (String word: wordDict) {
                l = word.length();             // 取每一个字符串和s进行后缀匹配
                if (l > i) {                   // wordDict中字符串长度比 s的i前缀还长
                    continue;
                }
                if (i != l && !dp[i-l]) {      // 前i-l字符无法通过字典匹配出来
                    continue;
                }

                //int start = i - l;
                int k;
                for (k = 0; k < l; k++) {
                    //if (s.charAt(start + k) != word.charAt(k)) {
                    if (s.charAt(i - l + k) != word.charAt(k)) {
                        break;
                    }
                }
                if (k == l) {                 // 说明匹配上了
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];   // 通过字符串列表拼接出前i个字符串，则dp[i] 为true
        dp[0] = true;
        for(int i = 1; i<= n; i++) {
            for (int j = 0; j<i;j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
