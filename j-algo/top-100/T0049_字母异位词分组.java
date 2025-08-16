import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * brief: 49. 字母异位词分组
 * <a href="https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * Created by lzy on 2025-08-15.
 */
public class T0049_字母异位词分组 {
    public static void main(String[] args) {
        T0049_字母异位词分组 t = new T0049_字母异位词分组();
        assertEquals(2, t.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"}).size());
        assertEquals(3, t.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).size());
        assertEquals(1, t.groupAnagrams(new String[]{""}).size());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            int[] count = new int[26];
            for (char c : chars) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // 这里的 if 是可省略的，但是加上 if 以后，生成的 sb 更短，后续 groupingBy 会更快。
                if (count[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(count[i]);
                }
            }
            //[0,10,1,0], [0,1,0,10]
            //b1d10  bdddddddddd
            //b10c1  bbbbbbbbbbc
            //a1e1t1  eat
            //a1e1t1  tea
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
