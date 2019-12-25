package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * result = max {以 arr[i] 结尾的字符串中的最长不重复子串}
 * result[i] = max {result[i-1],result[i-1]+arr[i]}
 * if (arr[i] == arr[i-1]) GG else result[i-1] + arr[i]
 * @author chahe
 * @date 2019-12-25
 */
public class LongestSubstringWithoutRepeatingCharacters {
    private static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha) + 1, start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end);
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
    }
}
